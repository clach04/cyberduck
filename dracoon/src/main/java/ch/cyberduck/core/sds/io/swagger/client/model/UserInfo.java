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
 * UserInfo
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-09-13T14:25:40.305+02:00")
public class UserInfo {
  @JsonProperty("id")
  private Long id = null;

  @JsonProperty("displayName")
  private String displayName = null;

  public UserInfo id(Long id) {
    this.id = id;
    return this;
  }

   /**
   * Unique identifier for the user
   * @return id
  **/
  @ApiModelProperty(required = true, value = "Unique identifier for the user")
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public UserInfo displayName(String displayName) {
    this.displayName = displayName;
      return this;
  }

    /**
     * Display name
     *
     * @return displayName
     **/
    @ApiModelProperty(required = true, value = "Display name")
  public String getDisplayName() {
    return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
      UserInfo userInfo = (UserInfo) o;
      return Objects.equals(this.id, userInfo.id) &&
          Objects.equals(this.displayName, userInfo.displayName);
  }

    @Override
    public int hashCode() {
        return Objects.hash(id, displayName);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UserInfo {\n");

      sb.append("    id: ").append(toIndentedString(id)).append("\n");
      sb.append("    displayName: ").append(toIndentedString(displayName)).append("\n");
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

