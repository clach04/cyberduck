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
 * UpdateMailServerConfig
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-09-13T14:25:40.305+02:00")
public class UpdateMailServerConfig {
  @JsonProperty("host")
  private String host = null;

  @JsonProperty("port")
  private Integer port = null;

  @JsonProperty("username")
  private String username = null;

  @JsonProperty("password")
  private String password = null;

  @JsonProperty("authenticationEnabled")
  private Boolean authenticationEnabled = null;

  @JsonProperty("sslEnabled")
  private Boolean sslEnabled = null;

  @JsonProperty("starttlsEnabled")
  private Boolean starttlsEnabled = null;

  @JsonProperty("resetUsername")
  private Boolean resetUsername = null;

  @JsonProperty("resetPassword")
  private Boolean resetPassword = null;

  public UpdateMailServerConfig host(String host) {
    this.host = host;
    return this;
  }

   /**
   * Email server host
   * @return host
  **/
  @ApiModelProperty(value = "Email server host")
  public String getHost() {
    return host;
  }

  public void setHost(String host) {
    this.host = host;
  }

  public UpdateMailServerConfig port(Integer port) {
    this.port = port;
    return this;
  }

   /**
   * Email server port
   * @return port
  **/
  @ApiModelProperty(value = "Email server port")
  public Integer getPort() {
    return port;
  }

  public void setPort(Integer port) {
    this.port = port;
  }

  public UpdateMailServerConfig username(String username) {
    this.username = username;
    return this;
  }

   /**
   * User name for email server
   * @return username
  **/
  @ApiModelProperty(value = "User name for email server")
  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public UpdateMailServerConfig password(String password) {
    this.password = password;
    return this;
  }

   /**
   * Password for email server
   * @return password
  **/
  @ApiModelProperty(value = "Password for email server")
  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public UpdateMailServerConfig authenticationEnabled(Boolean authenticationEnabled) {
    this.authenticationEnabled = authenticationEnabled;
    return this;
  }

   /**
    * Set &#x60;true&#x60; if the email server requires authentication.
   * @return authenticationEnabled
  **/
   @ApiModelProperty(example = "false", value = "Set `true` if the email server requires authentication.")
   public Boolean isAuthenticationEnabled() {
    return authenticationEnabled;
  }

  public void setAuthenticationEnabled(Boolean authenticationEnabled) {
    this.authenticationEnabled = authenticationEnabled;
  }

  public UpdateMailServerConfig sslEnabled(Boolean sslEnabled) {
    this.sslEnabled = sslEnabled;
    return this;
  }

   /**
    * Email server requires SSL connection? Requires &#x60;starttlsEnabled&#x60; to be &#x60;false&#x60;
   * @return sslEnabled
  **/
   @ApiModelProperty(example = "false", value = "Email server requires SSL connection? Requires `starttlsEnabled` to be `false`")
   public Boolean isSslEnabled() {
    return sslEnabled;
  }

  public void setSslEnabled(Boolean sslEnabled) {
    this.sslEnabled = sslEnabled;
  }

  public UpdateMailServerConfig starttlsEnabled(Boolean starttlsEnabled) {
    this.starttlsEnabled = starttlsEnabled;
    return this;
  }

   /**
    * Email server requires StartTLS connection? Requires &#x60;sslEnabled&#x60; to be &#x60;false&#x60;
   * @return starttlsEnabled
  **/
   @ApiModelProperty(example = "false", value = "Email server requires StartTLS connection? Requires `sslEnabled` to be `false`")
   public Boolean isStarttlsEnabled() {
    return starttlsEnabled;
  }

  public void setStarttlsEnabled(Boolean starttlsEnabled) {
    this.starttlsEnabled = starttlsEnabled;
  }

  public UpdateMailServerConfig resetUsername(Boolean resetUsername) {
    this.resetUsername = resetUsername;
    return this;
  }

   /**
    * Set &#x60;true&#x60; to reset email server &#x60;username&#x60;.
   * @return resetUsername
  **/
   @ApiModelProperty(example = "false", value = "Set `true` to reset email server `username`.")
   public Boolean isResetUsername() {
    return resetUsername;
  }

  public void setResetUsername(Boolean resetUsername) {
    this.resetUsername = resetUsername;
  }

  public UpdateMailServerConfig resetPassword(Boolean resetPassword) {
    this.resetPassword = resetPassword;
    return this;
  }

   /**
    * Set &#x60;true&#x60; to reset email server &#x60;password&#x60;.
   * @return resetPassword
  **/
   @ApiModelProperty(example = "false", value = "Set `true` to reset email server `password`.")
   public Boolean isResetPassword() {
    return resetPassword;
  }

  public void setResetPassword(Boolean resetPassword) {
    this.resetPassword = resetPassword;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UpdateMailServerConfig updateMailServerConfig = (UpdateMailServerConfig) o;
    return Objects.equals(this.host, updateMailServerConfig.host) &&
        Objects.equals(this.port, updateMailServerConfig.port) &&
        Objects.equals(this.username, updateMailServerConfig.username) &&
        Objects.equals(this.password, updateMailServerConfig.password) &&
        Objects.equals(this.authenticationEnabled, updateMailServerConfig.authenticationEnabled) &&
        Objects.equals(this.sslEnabled, updateMailServerConfig.sslEnabled) &&
        Objects.equals(this.starttlsEnabled, updateMailServerConfig.starttlsEnabled) &&
        Objects.equals(this.resetUsername, updateMailServerConfig.resetUsername) &&
        Objects.equals(this.resetPassword, updateMailServerConfig.resetPassword);
  }

  @Override
  public int hashCode() {
    return Objects.hash(host, port, username, password, authenticationEnabled, sslEnabled, starttlsEnabled, resetUsername, resetPassword);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UpdateMailServerConfig {\n");

      sb.append("    host: ").append(toIndentedString(host)).append("\n");
    sb.append("    port: ").append(toIndentedString(port)).append("\n");
    sb.append("    username: ").append(toIndentedString(username)).append("\n");
    sb.append("    password: ").append(toIndentedString(password)).append("\n");
    sb.append("    authenticationEnabled: ").append(toIndentedString(authenticationEnabled)).append("\n");
    sb.append("    sslEnabled: ").append(toIndentedString(sslEnabled)).append("\n");
    sb.append("    starttlsEnabled: ").append(toIndentedString(starttlsEnabled)).append("\n");
    sb.append("    resetUsername: ").append(toIndentedString(resetUsername)).append("\n");
    sb.append("    resetPassword: ").append(toIndentedString(resetPassword)).append("\n");
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

