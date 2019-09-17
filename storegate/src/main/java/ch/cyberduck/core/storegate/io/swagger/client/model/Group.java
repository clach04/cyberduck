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

import org.joda.time.DateTime;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * A group of users.
 */
@ApiModel(description = "A group of users.")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-09-13T14:06:08.665+02:00")
public class Group {
  @JsonProperty("id")
  private String id = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("description")
  private String description = null;

  @JsonProperty("created")
  private DateTime created = null;

  @JsonProperty("isSystemGroup")
  private Boolean isSystemGroup = null;

  public Group id(String id) {
    this.id = id;
    return this;
  }

   /**
   * The group id.
   * @return id
  **/
  @ApiModelProperty(value = "The group id.")
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public Group name(String name) {
    this.name = name;
    return this;
  }

   /**
   * The group name.
   * @return name
  **/
  @ApiModelProperty(value = "The group name.")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Group description(String description) {
    this.description = description;
    return this;
  }

   /**
   * The group description.
   * @return description
  **/
  @ApiModelProperty(value = "The group description.")
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Group created(DateTime created) {
    this.created = created;
    return this;
  }

   /**
   * 
   * @return created
  **/
  @ApiModelProperty(value = "")
  public DateTime getCreated() {
    return created;
  }

  public void setCreated(DateTime created) {
    this.created = created;
  }

  public Group isSystemGroup(Boolean isSystemGroup) {
    this.isSystemGroup = isSystemGroup;
    return this;
  }

   /**
   * Systemgroups can&#39;t be edited
   * @return isSystemGroup
  **/
  @ApiModelProperty(value = "Systemgroups can't be edited")
  public Boolean isIsSystemGroup() {
    return isSystemGroup;
  }

  public void setIsSystemGroup(Boolean isSystemGroup) {
    this.isSystemGroup = isSystemGroup;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Group group = (Group) o;
    return Objects.equals(this.id, group.id) &&
        Objects.equals(this.name, group.name) &&
        Objects.equals(this.description, group.description) &&
        Objects.equals(this.created, group.created) &&
        Objects.equals(this.isSystemGroup, group.isSystemGroup);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, description, created, isSystemGroup);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Group {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    created: ").append(toIndentedString(created)).append("\n");
    sb.append("    isSystemGroup: ").append(toIndentedString(isSystemGroup)).append("\n");
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

