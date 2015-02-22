package ch.cyberduck.core.azure;

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

import ch.cyberduck.core.AbstractPath;
import ch.cyberduck.core.AttributedList;
import ch.cyberduck.core.ListProgressListener;
import ch.cyberduck.core.ListService;
import ch.cyberduck.core.Path;
import ch.cyberduck.core.PathAttributes;
import ch.cyberduck.core.PathContainerService;
import ch.cyberduck.core.PathNormalizer;
import ch.cyberduck.core.exception.BackgroundException;
import ch.cyberduck.core.exception.NotfoundException;
import ch.cyberduck.core.io.Checksum;
import ch.cyberduck.core.io.HashAlgorithm;
import ch.cyberduck.core.preferences.PreferencesFactory;

import org.apache.commons.lang3.StringUtils;

import java.net.URISyntaxException;
import java.util.EnumSet;

import com.microsoft.azure.storage.OperationContext;
import com.microsoft.azure.storage.ResultContinuation;
import com.microsoft.azure.storage.ResultSegment;
import com.microsoft.azure.storage.RetryNoRetry;
import com.microsoft.azure.storage.StorageException;
import com.microsoft.azure.storage.blob.BlobListingDetails;
import com.microsoft.azure.storage.blob.BlobRequestOptions;
import com.microsoft.azure.storage.blob.CloudBlob;
import com.microsoft.azure.storage.blob.CloudBlobContainer;
import com.microsoft.azure.storage.blob.CloudBlobDirectory;
import com.microsoft.azure.storage.blob.ListBlobItem;

/**
 * @version $Id$
 */
public class AzureObjectListService implements ListService {

    private AzureSession session;

    private OperationContext context;

    private PathContainerService containerService
            = new AzurePathContainerService();

    public AzureObjectListService(final AzureSession session, final OperationContext context) {
        this.session = session;
        this.context = context;
    }

    @Override
    public AttributedList<Path> list(final Path directory, final ListProgressListener listener) throws BackgroundException {
        try {
            final CloudBlobContainer container = session.getClient().getContainerReference(containerService.getContainer(directory).getName());
            final AttributedList<Path> children = new AttributedList<Path>();
            ResultContinuation token = null;
            ResultSegment<ListBlobItem> result;
            final String prefix;
            if(containerService.isContainer(directory)) {
                prefix = StringUtils.EMPTY;
            }
            else {
                prefix = containerService.getKey(directory);
            }
            do {
                final BlobRequestOptions options = new BlobRequestOptions();
                options.setRetryPolicyFactory(new RetryNoRetry());
                result = container.listBlobsSegmented(
                        prefix, false, EnumSet.noneOf(BlobListingDetails.class),
                        PreferencesFactory.get().getInteger("azure.listing.chunksize"), token, options, context);
                for(ListBlobItem object : result.getResults()) {
                    if(new Path(object.getUri().getPath(), EnumSet.of(Path.Type.directory)).equals(directory)) {
                        continue;
                    }
                    final PathAttributes attributes = new PathAttributes();
                    if(object instanceof CloudBlob) {
                        final CloudBlob blob = (CloudBlob) object;
                        attributes.setSize(blob.getProperties().getLength());
                        attributes.setModificationDate(blob.getProperties().getLastModified().getTime());
                        attributes.setETag(blob.getProperties().getEtag());
                        if(StringUtils.isNotBlank(blob.getProperties().getContentMD5())) {
                            attributes.setChecksum(new Checksum(HashAlgorithm.md5, blob.getProperties().getContentMD5()));
                        }
                    }
                    final EnumSet<AbstractPath.Type> types = object instanceof CloudBlobDirectory
                            ? EnumSet.of(Path.Type.directory) : EnumSet.of(Path.Type.file);
                    if(StringUtils.endsWith(object.getUri().getPath(), String.valueOf(Path.DELIMITER))) {
                        types.add(Path.Type.placeholder);
                    }
                    final Path child = new Path(directory, PathNormalizer.name(object.getUri().getPath()), types, attributes);
                    children.add(child);
                }
                listener.chunk(directory, children);
                token = result.getContinuationToken();
            }
            while(result.getHasMoreResults());
            return children;
        }
        catch(StorageException e) {
            throw new AzureExceptionMappingService().map("Listing directory {0} failed", e, directory);
        }
        catch(URISyntaxException e) {
            throw new NotfoundException(e.getMessage(), e);
        }
    }
}
