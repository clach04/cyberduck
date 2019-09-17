/*
 * DRACOON
 * REST Web Services for DRACOON<br>Version: 4.13.0  - built at: 2019-08-07 15:10:42<br><br><a title='Developer Information' href='https://developer.dracoon.com'>Developer Information</a>&emsp;&emsp;<a title='Get SDKs on GitHub' href='https://github.com/dracoon'>Get SDKs on GitHub</a>
 *
 * OpenAPI spec version: 4.13.0
 *
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package ch.cyberduck.core.sds.io.swagger.client.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Request model for sending an email of a Download Share link
 */
@ApiModel(description = "Request model for sending an email of a Download Share link")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-09-13T14:08:20.178+02:00")
public class DownloadShareLinkEmail {
    @JsonProperty("recipients")
    private List<String> recipients = new ArrayList<>();

    @JsonProperty("body")
    private String body = null;

    @JsonProperty("receiverLanguage")
    private String receiverLanguage = null;

    public DownloadShareLinkEmail recipients(List<String> recipients) {
        this.recipients = recipients;
        return this;
    }

    public DownloadShareLinkEmail addRecipientsItem(String recipientsItem) {
        this.recipients.add(recipientsItem);
        return this;
    }

    /**
     * List of recipient email addresses
     *
     * @return recipients
     **/
    @ApiModelProperty(required = true, value = "List of recipient email addresses")
    public List<String> getRecipients() {
        return recipients;
    }

    public void setRecipients(List<String> recipients) {
        this.recipients = recipients;
    }

    public DownloadShareLinkEmail body(String body) {
        this.body = body;
        return this;
    }

    /**
     * Notification email content
     *
     * @return body
     **/
    @ApiModelProperty(required = true, value = "Notification email content")
    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public DownloadShareLinkEmail receiverLanguage(String receiverLanguage) {
        this.receiverLanguage = receiverLanguage;
        return this;
    }

    /**
     * Language tag for messages to receiver
     *
     * @return receiverLanguage
     **/
    @ApiModelProperty(example = "de-DE", value = "Language tag for messages to receiver")
    public String getReceiverLanguage() {
        return receiverLanguage;
    }

    public void setReceiverLanguage(String receiverLanguage) {
        this.receiverLanguage = receiverLanguage;
    }


    @Override
    public boolean equals(java.lang.Object o) {
        if(this == o) {
            return true;
        }
        if(o == null || getClass() != o.getClass()) {
            return false;
        }
        DownloadShareLinkEmail downloadShareLinkEmail = (DownloadShareLinkEmail) o;
        return Objects.equals(this.recipients, downloadShareLinkEmail.recipients) &&
            Objects.equals(this.body, downloadShareLinkEmail.body) &&
            Objects.equals(this.receiverLanguage, downloadShareLinkEmail.receiverLanguage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(recipients, body, receiverLanguage);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class DownloadShareLinkEmail {\n");

        sb.append("    recipients: ").append(toIndentedString(recipients)).append("\n");
        sb.append("    body: ").append(toIndentedString(body)).append("\n");
        sb.append("    receiverLanguage: ").append(toIndentedString(receiverLanguage)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(java.lang.Object o) {
        if(o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }

}

