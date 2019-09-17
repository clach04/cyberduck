/*
 * DRACOON
 * REST Web Services for DRACOON<br>Version: 4.10.7-LTS  - built at: 2019-03-19 14:24:35<br><br><a title='Developer Information' href='https://developer.dracoon.com'>Developer Information</a>&emsp;&emsp;<a title='Get SDKs on GitHub' href='https://github.com/dracoon'>Get SDKs on GitHub</a>
 *
 * OpenAPI spec version: 4.10.7-LTS
 *
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package ch.cyberduck.core.sds.io.swagger.client.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

/**
 * GeneralSettingsInfo
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-09-13T14:25:40.305+02:00")
public class GeneralSettingsInfo {
    @JsonProperty("sharePasswordSmsEnabled")
    private Boolean sharePasswordSmsEnabled = null;

    @JsonProperty("cryptoEnabled")
    private Boolean cryptoEnabled = null;

    @JsonProperty("emailNotificationButtonEnabled")
    private Boolean emailNotificationButtonEnabled = null;

    @JsonProperty("eulaEnabled")
    private Boolean eulaEnabled = null;

    @JsonProperty("mediaServerEnabled")
    private Boolean mediaServerEnabled = null;

    @JsonProperty("weakPasswordEnabled")
    private Boolean weakPasswordEnabled = null;

    @JsonProperty("useS3Storage")
    private Boolean useS3Storage = null;

    @JsonProperty("s3TagsEnabled")
    private Boolean s3TagsEnabled = null;

    @JsonProperty("homeRoomsActive")
    private Boolean homeRoomsActive = null;

    @JsonProperty("homeRoomParentId")
    private Long homeRoomParentId = null;

    public GeneralSettingsInfo sharePasswordSmsEnabled(Boolean sharePasswordSmsEnabled) {
        this.sharePasswordSmsEnabled = sharePasswordSmsEnabled;
        return this;
    }

    /**
     * Allow sending of share passwords via SMS
     *
     * @return sharePasswordSmsEnabled
     **/
    @ApiModelProperty(example = "false", value = "Allow sending of share passwords via SMS")
    public Boolean isSharePasswordSmsEnabled() {
        return sharePasswordSmsEnabled;
    }

    public void setSharePasswordSmsEnabled(Boolean sharePasswordSmsEnabled) {
        this.sharePasswordSmsEnabled = sharePasswordSmsEnabled;
    }

    public GeneralSettingsInfo cryptoEnabled(Boolean cryptoEnabled) {
        this.cryptoEnabled = cryptoEnabled;
        return this;
    }

    /**
     * Activation status of client-side encryption. Can only be enabled once; disabling is not possible.
     *
     * @return cryptoEnabled
     **/
    @ApiModelProperty(example = "false", value = "Activation status of client-side encryption. Can only be enabled once; disabling is not possible.")
    public Boolean isCryptoEnabled() {
        return cryptoEnabled;
    }

    public void setCryptoEnabled(Boolean cryptoEnabled) {
        this.cryptoEnabled = cryptoEnabled;
    }

    public GeneralSettingsInfo emailNotificationButtonEnabled(Boolean emailNotificationButtonEnabled) {
        this.emailNotificationButtonEnabled = emailNotificationButtonEnabled;
        return this;
    }

    /**
     * Enable email notification button
     *
     * @return emailNotificationButtonEnabled
     **/
    @ApiModelProperty(example = "false", value = "Enable email notification button")
    public Boolean isEmailNotificationButtonEnabled() {
        return emailNotificationButtonEnabled;
    }

    public void setEmailNotificationButtonEnabled(Boolean emailNotificationButtonEnabled) {
        this.emailNotificationButtonEnabled = emailNotificationButtonEnabled;
    }

    public GeneralSettingsInfo eulaEnabled(Boolean eulaEnabled) {
        this.eulaEnabled = eulaEnabled;
        return this;
    }

    /**
     * Each user has to confirm the EULA at first login.
     *
     * @return eulaEnabled
     **/
    @ApiModelProperty(example = "false", value = "Each user has to confirm the EULA at first login.")
    public Boolean isEulaEnabled() {
        return eulaEnabled;
    }

    public void setEulaEnabled(Boolean eulaEnabled) {
        this.eulaEnabled = eulaEnabled;
    }

    public GeneralSettingsInfo mediaServerEnabled(Boolean mediaServerEnabled) {
        this.mediaServerEnabled = mediaServerEnabled;
        return this;
    }

    /**
     * Is media server enabled?
     *
     * @return mediaServerEnabled
     **/
    @ApiModelProperty(example = "false", value = "Is media server enabled?")
    public Boolean isMediaServerEnabled() {
        return mediaServerEnabled;
    }

    public void setMediaServerEnabled(Boolean mediaServerEnabled) {
        this.mediaServerEnabled = mediaServerEnabled;
    }

    public GeneralSettingsInfo weakPasswordEnabled(Boolean weakPasswordEnabled) {
        this.weakPasswordEnabled = weakPasswordEnabled;
        return this;
    }

    /**
     * Allow weak password * A weak password has to fulfill the following criteria:    * is at least 8 characters long    * contains letters and numbers * A strong password has to fulfill the following criteria in addition:    * contains at least one special character    * contains upper and lower case characters
     *
     * @return weakPasswordEnabled
     **/
    @ApiModelProperty(example = "false", value = "Allow weak password * A weak password has to fulfill the following criteria:    * is at least 8 characters long    * contains letters and numbers * A strong password has to fulfill the following criteria in addition:    * contains at least one special character    * contains upper and lower case characters")
    public Boolean isWeakPasswordEnabled() {
        return weakPasswordEnabled;
    }

    public void setWeakPasswordEnabled(Boolean weakPasswordEnabled) {
        this.weakPasswordEnabled = weakPasswordEnabled;
    }

    public GeneralSettingsInfo useS3Storage(Boolean useS3Storage) {
        this.useS3Storage = useS3Storage;
        return this;
    }

    /**
     * Defines if S3 is used as storage backend
     *
     * @return useS3Storage
     **/
    @ApiModelProperty(example = "false", value = "Defines if S3 is used as storage backend")
    public Boolean isUseS3Storage() {
        return useS3Storage;
    }

    public void setUseS3Storage(Boolean useS3Storage) {
        this.useS3Storage = useS3Storage;
    }

    public GeneralSettingsInfo s3TagsEnabled(Boolean s3TagsEnabled) {
        this.s3TagsEnabled = s3TagsEnabled;
        return this;
    }

    /**
     * Defines if S3 tags are enabled  [Since version 4.9.0]
     *
     * @return s3TagsEnabled
     **/
    @ApiModelProperty(example = "false", value = "Defines if S3 tags are enabled  [Since version 4.9.0]")
    public Boolean isS3TagsEnabled() {
        return s3TagsEnabled;
    }

    public void setS3TagsEnabled(Boolean s3TagsEnabled) {
        this.s3TagsEnabled = s3TagsEnabled;
    }

    public GeneralSettingsInfo homeRoomsActive(Boolean homeRoomsActive) {
        this.homeRoomsActive = homeRoomsActive;
        return this;
    }

    /**
     * Homerooms active  [Since version 4.10.2]
     *
     * @return homeRoomsActive
     **/
    @ApiModelProperty(example = "false", value = "Homerooms active  [Since version 4.10.2]")
    public Boolean isHomeRoomsActive() {
        return homeRoomsActive;
    }

    public void setHomeRoomsActive(Boolean homeRoomsActive) {
        this.homeRoomsActive = homeRoomsActive;
    }

    public GeneralSettingsInfo homeRoomParentId(Long homeRoomParentId) {
        this.homeRoomParentId = homeRoomParentId;
        return this;
    }

    /**
     * Homeroom Parent ID  [Since version 4.10.2]
     *
     * @return homeRoomParentId
     **/
    @ApiModelProperty(value = "Homeroom Parent ID  [Since version 4.10.2]")
    public Long getHomeRoomParentId() {
        return homeRoomParentId;
    }

    public void setHomeRoomParentId(Long homeRoomParentId) {
        this.homeRoomParentId = homeRoomParentId;
    }


    @Override
    public boolean equals(java.lang.Object o) {
        if(this == o) {
            return true;
        }
        if(o == null || getClass() != o.getClass()) {
            return false;
        }
        GeneralSettingsInfo generalSettingsInfo = (GeneralSettingsInfo) o;
        return Objects.equals(this.sharePasswordSmsEnabled, generalSettingsInfo.sharePasswordSmsEnabled) &&
            Objects.equals(this.cryptoEnabled, generalSettingsInfo.cryptoEnabled) &&
            Objects.equals(this.emailNotificationButtonEnabled, generalSettingsInfo.emailNotificationButtonEnabled) &&
            Objects.equals(this.eulaEnabled, generalSettingsInfo.eulaEnabled) &&
            Objects.equals(this.mediaServerEnabled, generalSettingsInfo.mediaServerEnabled) &&
            Objects.equals(this.weakPasswordEnabled, generalSettingsInfo.weakPasswordEnabled) &&
            Objects.equals(this.useS3Storage, generalSettingsInfo.useS3Storage) &&
            Objects.equals(this.s3TagsEnabled, generalSettingsInfo.s3TagsEnabled) &&
            Objects.equals(this.homeRoomsActive, generalSettingsInfo.homeRoomsActive) &&
            Objects.equals(this.homeRoomParentId, generalSettingsInfo.homeRoomParentId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sharePasswordSmsEnabled, cryptoEnabled, emailNotificationButtonEnabled, eulaEnabled, mediaServerEnabled, weakPasswordEnabled, useS3Storage, s3TagsEnabled, homeRoomsActive, homeRoomParentId);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class GeneralSettingsInfo {\n");

        sb.append("    sharePasswordSmsEnabled: ").append(toIndentedString(sharePasswordSmsEnabled)).append("\n");
        sb.append("    cryptoEnabled: ").append(toIndentedString(cryptoEnabled)).append("\n");
        sb.append("    emailNotificationButtonEnabled: ").append(toIndentedString(emailNotificationButtonEnabled)).append("\n");
        sb.append("    eulaEnabled: ").append(toIndentedString(eulaEnabled)).append("\n");
        sb.append("    mediaServerEnabled: ").append(toIndentedString(mediaServerEnabled)).append("\n");
        sb.append("    weakPasswordEnabled: ").append(toIndentedString(weakPasswordEnabled)).append("\n");
        sb.append("    useS3Storage: ").append(toIndentedString(useS3Storage)).append("\n");
        sb.append("    s3TagsEnabled: ").append(toIndentedString(s3TagsEnabled)).append("\n");
        sb.append("    homeRoomsActive: ").append(toIndentedString(homeRoomsActive)).append("\n");
        sb.append("    homeRoomParentId: ").append(toIndentedString(homeRoomParentId)).append("\n");
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

