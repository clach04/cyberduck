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
 * PublicKeyContainer
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-09-13T14:25:40.305+02:00")
public class PublicKeyContainer {
  @JsonProperty("version")
  private String version = null;

  @JsonProperty("publicKey")
  private String publicKey = null;

  public PublicKeyContainer version(String version) {
    this.version = version;
    return this;
  }

   /**
   * Version
   * @return version
  **/
  @ApiModelProperty(example = "A", required = true, value = "Version")
  public String getVersion() {
    return version;
  }

  public void setVersion(String version) {
    this.version = version;
  }

  public PublicKeyContainer publicKey(String publicKey) {
    this.publicKey = publicKey;
    return this;
  }

   /**
   * Public key
   * @return publicKey
  **/
  @ApiModelProperty(required = true, value = "Public key")
  public String getPublicKey() {
    return publicKey;
  }

  public void setPublicKey(String publicKey) {
    this.publicKey = publicKey;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PublicKeyContainer publicKeyContainer = (PublicKeyContainer) o;
    return Objects.equals(this.version, publicKeyContainer.version) &&
        Objects.equals(this.publicKey, publicKeyContainer.publicKey);
  }

  @Override
  public int hashCode() {
    return Objects.hash(version, publicKey);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PublicKeyContainer {\n");

      sb.append("    version: ").append(toIndentedString(version)).append("\n");
    sb.append("    publicKey: ").append(toIndentedString(publicKey)).append("\n");
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

