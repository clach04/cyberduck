/*
 * Storegate.Web
 * No description provided (generated by Swagger Codegen https://github.com/swagger-api/swagger-codegen)
 *
 * OpenAPI spec version: v4
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package ch.cyberduck.core.storegate.io.swagger.client.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 
 */
@ApiModel(description = "")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-09-13T14:06:08.665+02:00")
public class AlertSettingsRequest {
  @JsonProperty("clientConnectionAlertDays")
  private Integer clientConnectionAlertDays = null;

  @JsonProperty("fileTransferAlertDays")
  private Integer fileTransferAlertDays = null;

  @JsonProperty("storageAlertDays")
  private Integer storageAlertDays = null;

  @JsonProperty("emails")
  private List<String> emails = null;

  public AlertSettingsRequest clientConnectionAlertDays(Integer clientConnectionAlertDays) {
    this.clientConnectionAlertDays = clientConnectionAlertDays;
    return this;
  }

   /**
   * Alert after days
   * @return clientConnectionAlertDays
  **/
  @ApiModelProperty(value = "Alert after days")
  public Integer getClientConnectionAlertDays() {
    return clientConnectionAlertDays;
  }

  public void setClientConnectionAlertDays(Integer clientConnectionAlertDays) {
    this.clientConnectionAlertDays = clientConnectionAlertDays;
  }

  public AlertSettingsRequest fileTransferAlertDays(Integer fileTransferAlertDays) {
    this.fileTransferAlertDays = fileTransferAlertDays;
    return this;
  }

   /**
   * Alert after days
   * @return fileTransferAlertDays
  **/
  @ApiModelProperty(value = "Alert after days")
  public Integer getFileTransferAlertDays() {
    return fileTransferAlertDays;
  }

  public void setFileTransferAlertDays(Integer fileTransferAlertDays) {
    this.fileTransferAlertDays = fileTransferAlertDays;
  }

  public AlertSettingsRequest storageAlertDays(Integer storageAlertDays) {
    this.storageAlertDays = storageAlertDays;
    return this;
  }

   /**
   * Alert after days
   * @return storageAlertDays
  **/
  @ApiModelProperty(value = "Alert after days")
  public Integer getStorageAlertDays() {
    return storageAlertDays;
  }

  public void setStorageAlertDays(Integer storageAlertDays) {
    this.storageAlertDays = storageAlertDays;
  }

  public AlertSettingsRequest emails(List<String> emails) {
    this.emails = emails;
    return this;
  }

  public AlertSettingsRequest addEmailsItem(String emailsItem) {
    if (this.emails == null) {
        this.emails = new ArrayList<>();
    }
    this.emails.add(emailsItem);
    return this;
  }

   /**
   * List of receivers
   * @return emails
  **/
  @ApiModelProperty(value = "List of receivers")
  public List<String> getEmails() {
    return emails;
  }

  public void setEmails(List<String> emails) {
    this.emails = emails;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AlertSettingsRequest alertSettingsRequest = (AlertSettingsRequest) o;
    return Objects.equals(this.clientConnectionAlertDays, alertSettingsRequest.clientConnectionAlertDays) &&
        Objects.equals(this.fileTransferAlertDays, alertSettingsRequest.fileTransferAlertDays) &&
        Objects.equals(this.storageAlertDays, alertSettingsRequest.storageAlertDays) &&
        Objects.equals(this.emails, alertSettingsRequest.emails);
  }

  @Override
  public int hashCode() {
    return Objects.hash(clientConnectionAlertDays, fileTransferAlertDays, storageAlertDays, emails);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AlertSettingsRequest {\n");
    
    sb.append("    clientConnectionAlertDays: ").append(toIndentedString(clientConnectionAlertDays)).append("\n");
    sb.append("    fileTransferAlertDays: ").append(toIndentedString(fileTransferAlertDays)).append("\n");
    sb.append("    storageAlertDays: ").append(toIndentedString(storageAlertDays)).append("\n");
    sb.append("    emails: ").append(toIndentedString(emails)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}

