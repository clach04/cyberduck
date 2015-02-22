package ch.cyberduck.core.s3;

/*
 * Copyright (c) 2002-2014 David Kocher. All rights reserved.
 * http://cyberduck.io/
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * Bug fixes, suggestions and comments should be sent to:
 * feedback@cyberduck.io
 */

import ch.cyberduck.core.Host;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.jets3t.service.security.ProviderCredentials;
import org.jets3t.service.utils.RestUtils;
import org.jets3t.service.utils.ServiceUtils;
import org.jets3t.service.utils.SignatureUtils;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collections;
import java.util.Date;
import java.util.Map;
import java.util.TreeMap;

/**
 * @version $Id$
 */
public class S3PresignedUrlProvider {
    private static final Logger log = Logger.getLogger(S3PresignedUrlProvider.class);

    private Host endpoint;

    public S3PresignedUrlProvider(final Host endpoint) {
        this.endpoint = endpoint;
    }

    /**
     * Generates a signed URL string that will grant access to an S3 resource (bucket or object)
     * to whoever uses the URL up until the time specified.
     *
     * @param method                    the HTTP method to sign, such as GET or PUT (note that S3 does not support POST requests).
     * @param bucket                    the name of the bucket to include in the URL, must be a valid bucket name.
     * @param key                       the name of the object to include in the URL, if null only the bucket name is used.
     * @param secondsSinceEpoch         the time after which URL's signature will no longer be valid. This time cannot be null.
     *                                  <b>Note:</b> This time is specified in seconds since the epoch, not milliseconds.
     * @param isVirtualHost             if this parameter is true, the bucket name is treated as a virtual host name. To use
     *                                  this option, the bucket name must be a valid DNS name that is an alias to an S3 bucket.
     * @return a URL signed in such a way as to grant access to an S3 resource to whoever uses it.
     */
    public String create(final ProviderCredentials credentials,
                         final String method, final String bucket, final String region, final String key,
                         final long secondsSinceEpoch,
                         final boolean isVirtualHost) {
        final String requestSignatureVersion;
        if(StringUtils.isNotBlank(region)) {
            requestSignatureVersion = S3Protocol.AuthenticationHeaderSignatureVersion.AWS4HMACSHA256.toString();
        }
        else {
            requestSignatureVersion = S3Protocol.AuthenticationHeaderSignatureVersion.AWS2.toString();
        }
        String s3Endpoint = endpoint.getHostname();
        String uriPath;

        String hostname = (isVirtualHost
                ? bucket
                : ServiceUtils.generateS3HostnameForBucket(
                bucket, false, s3Endpoint));

        // If we are using an alternative hostname, include the hostname/bucketname in the resource path.
        String virtualBucketPath = "";
        if(!s3Endpoint.equals(hostname)) {
            int subdomainOffset = hostname.lastIndexOf("." + s3Endpoint);
            if(subdomainOffset > 0) {
                // Hostname represents an S3 sub-domain, so the bucket's name is the CNAME portion
                virtualBucketPath = hostname.substring(0, subdomainOffset) + "/";
            }
            else {
                // Hostname represents a virtual host, so the bucket's name is identical to hostname
                virtualBucketPath = hostname + "/";
            }
            uriPath = (key != null ? RestUtils.encodeUrlPath(key, "/") : "");
        }
        else {
            uriPath = bucket + (key != null ? "/" + RestUtils.encodeUrlPath(key, "/") : "");
        }
        uriPath += "?";
        final String serviceEndpointVirtualPath = "";
        String uriPrefix = endpoint.getProtocol().getScheme() + "://" + hostname
                + (endpoint.getPort() != endpoint.getProtocol().getScheme().getPort() ? ":" + endpoint.getPort() : "")
                + serviceEndpointVirtualPath;
        if("AWS4-HMAC-SHA256".equalsIgnoreCase(requestSignatureVersion)) {
            Date now = new Date();
            String service = "s3";
            String accessKey = credentials.getAccessKey();
            String secretKey = credentials.getSecretKey();
            String timestampISO8601 =
                    SignatureUtils.formatAwsFlavouredISO8601Date(now);
            String datestampISO8601 = timestampISO8601.substring(0, 8);

            // Convert seconds since epoch expiry time format into
            // seconds-unti-expiry form used by version 4.
            long secondsUntilExpiry = secondsSinceEpoch - (now.getTime() / 1000);
            Map<String, String> headersToSignMap = new TreeMap<String, String>();
            // Signed headers must always include "host"
            headersToSignMap.put("host", hostname);

            String credential =
                    accessKey + "/" + datestampISO8601 + "/" + region + "/" + service + "/aws4_request";

            String signedHeaders = ServiceUtils.join(
                    headersToSignMap.keySet().toArray(), ";");

            uriPath += "X-Amz-Algorithm=" + requestSignatureVersion
                    + "&X-Amz-Credential=" + credential
                    + "&X-Amz-Date=" + timestampISO8601
                    + "&X-Amz-Expires=" + secondsUntilExpiry
                    + "&X-Amz-SignedHeaders=" + signedHeaders;

            // Canonical request string
            String canonicalRequestString;
            try {
                // Adjust hostname for specific regions
                URI uriWithCorrectedHostname =
                        SignatureUtils.awsV4CorrectHostnameForRegion(
                                new URI(uriPrefix), region);
                headersToSignMap.put("host", uriWithCorrectedHostname.getHost());
                uriPrefix = uriWithCorrectedHostname.toString();

                // Set payload SHA256 hash, which is a place-holder value by
                // default but takes on an object's content SHA256 value if this
                // is known and set in the headers.
                String payloadSha256Hash = "UNSIGNED-PAYLOAD";
                if(headersToSignMap.containsKey("x-amz-content-sha256")) {
                    payloadSha256Hash = headersToSignMap.get("x-amz-content-sha256");
                }

                canonicalRequestString =
                        SignatureUtils.awsV4BuildCanonicalRequestString(
                                new URI(uriPrefix + "/" + uriPath),
                                method, headersToSignMap, payloadSha256Hash);
            }
            catch(URISyntaxException e) {
                throw new RuntimeException(e);
            }
            String stringToSign = SignatureUtils.awsV4BuildStringToSign(
                    requestSignatureVersion, canonicalRequestString,
                    timestampISO8601, region);
            byte[] signingKey = SignatureUtils.awsV4BuildSigningKey(
                    secretKey, timestampISO8601, region);
            String signature = ServiceUtils.toHex(ServiceUtils.hmacSHA256(
                    signingKey, ServiceUtils.stringToBytes(stringToSign)));

            uriPath += "&X-Amz-Signature=" + signature;
        }
        else if("AWS2".equalsIgnoreCase(requestSignatureVersion)) {
            uriPath += "AWSAccessKeyId=" + credentials.getAccessKey();
            uriPath += "&Expires=" + secondsSinceEpoch;

            String canonicalString = RestUtils.makeServiceCanonicalString(method,
                    serviceEndpointVirtualPath + "/" + virtualBucketPath + uriPath,
                    Collections.<String, Object>emptyMap(), String.valueOf(secondsSinceEpoch),
                    "x-amz-", Collections.<String>emptyList());
            if(log.isDebugEnabled()) {
                log.debug("Signing canonical string:\n" + canonicalString);
            }

            String signedCanonical = ServiceUtils.signWithHmacSha1(credentials.getSecretKey(),
                    canonicalString);
            String encodedCanonical = RestUtils.encodeUrlString(signedCanonical);
            uriPath += "&Signature=" + encodedCanonical;
        }
        else {
            return null;
        }
        return uriPrefix + "/" + uriPath;
    }
}
