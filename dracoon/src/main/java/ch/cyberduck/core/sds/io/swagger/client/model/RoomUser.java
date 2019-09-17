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
 * RoomUser
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-09-13T14:25:40.305+02:00")
public class RoomUser {
    @JsonProperty("id")
    private Long id = null;

    @JsonProperty("isGranted")
    private Boolean isGranted = null;

  @JsonProperty("login")
  private String login = null;

  @JsonProperty("displayName")
  private String displayName = null;

  @JsonProperty("email")
  private String email = null;

  @JsonProperty("permissions")
  private NodePermissions permissions = null;

  @JsonProperty("publicKeyContainer")
  private PublicKeyContainer publicKeyContainer = null;

    public RoomUser id(Long id) {
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

  public RoomUser isGranted(Boolean isGranted) {
    this.isGranted = isGranted;
    return this;
  }

   /**
   * Is user granted room permissions
   * @return isGranted
  **/
   @ApiModelProperty(example = "false", required = true, value = "Is user granted room permissions")
   public Boolean isIsGranted() {
    return isGranted;
  }

  public void setIsGranted(Boolean isGranted) {
    this.isGranted = isGranted;
  }

  public RoomUser login(String login) {
    this.login = login;
    return this;
  }

    /**
     * User login name
   * @return login
     **/
    @ApiModelProperty(required = true, value = "User login name")
  public String getLogin() {
    return login;
  }

  public void setLogin(String login) {
    this.login = login;
  }

  public RoomUser displayName(String displayName) {
    this.displayName = displayName;
    return this;
  }

    /**
     * Display name
   * @return displayName
     **/
    @ApiModelProperty(required = true, value = "Display name")
  public String getDisplayName() {
    return displayName;
  }

  public void setDisplayName(String displayName) {
    this.displayName = displayName;
  }

  public RoomUser email(String email) {
    this.email = email;
    return this;
  }

    /**
     * Email (not used)
   * @return email
     **/
    @ApiModelProperty(example = "john.doe@email.com", required = true, value = "Email (not used)")
  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public RoomUser permissions(NodePermissions permissions) {
    this.permissions = permissions;
    return this;
  }

   /**
   * Available permissions for this node
   * @return permissions
  **/
  @ApiModelProperty(value = "Available permissions for this node")
  public NodePermissions getPermissions() {
    return permissions;
  }

  public void setPermissions(NodePermissions permissions) {
    this.permissions = permissions;
  }

  public RoomUser publicKeyContainer(PublicKeyContainer publicKeyContainer) {
    this.publicKeyContainer = publicKeyContainer;
    return this;
  }

   /**
   * Public key container (private key and version)
   * @return publicKeyContainer
  **/
  @ApiModelProperty(value = "Public key container (private key and version)")
  public PublicKeyContainer getPublicKeyContainer() {
    return publicKeyContainer;
  }

  public void setPublicKeyContainer(PublicKeyContainer publicKeyContainer) {
    this.publicKeyContainer = publicKeyContainer;
  }


    @Override
    public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RoomUser roomUser = (RoomUser) o;
        return Objects.equals(this.id, roomUser.id) &&
        Objects.equals(this.isGranted, roomUser.isGranted) &&
        Objects.equals(this.login, roomUser.login) &&
        Objects.equals(this.displayName, roomUser.displayName) &&
        Objects.equals(this.email, roomUser.email) &&
        Objects.equals(this.permissions, roomUser.permissions) &&
        Objects.equals(this.publicKeyContainer, roomUser.publicKeyContainer);
  }

  @Override
  public int hashCode() {
      return Objects.hash(id, isGranted, login, displayName, email, permissions, publicKeyContainer);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RoomUser {\n");

      sb.append("    id: ").append(toIndentedString(id)).append("\n");
      sb.append("    isGranted: ").append(toIndentedString(isGranted)).append("\n");
    sb.append("    login: ").append(toIndentedString(login)).append("\n");
    sb.append("    displayName: ").append(toIndentedString(displayName)).append("\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
    sb.append("    permissions: ").append(toIndentedString(permissions)).append("\n");
    sb.append("    publicKeyContainer: ").append(toIndentedString(publicKeyContainer)).append("\n");
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

