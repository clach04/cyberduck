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

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

/**
 * UserGroupList
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-09-13T14:25:40.305+02:00")
public class UserGroupList {
  @JsonProperty("range")
  private Range range = null;

  @JsonProperty("items")
  private List<UserGroup> items = new ArrayList<>();

  public UserGroupList range(Range range) {
    this.range = range;
    return this;
  }

   /**
   * Range
   * @return range
  **/
  @ApiModelProperty(required = true, value = "Range")
  public Range getRange() {
    return range;
  }

  public void setRange(Range range) {
    this.range = range;
  }

  public UserGroupList items(List<UserGroup> items) {
    this.items = items;
    return this;
  }

  public UserGroupList addItemsItem(UserGroup itemsItem) {
    this.items.add(itemsItem);
    return this;
  }

   /**
   * List of user-group mappings
   * @return items
  **/
  @ApiModelProperty(required = true, value = "List of user-group mappings")
  public List<UserGroup> getItems() {
    return items;
  }

  public void setItems(List<UserGroup> items) {
    this.items = items;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UserGroupList userGroupList = (UserGroupList) o;
    return Objects.equals(this.range, userGroupList.range) &&
        Objects.equals(this.items, userGroupList.items);
  }

  @Override
  public int hashCode() {
    return Objects.hash(range, items);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UserGroupList {\n");

      sb.append("    range: ").append(toIndentedString(range)).append("\n");
    sb.append("    items: ").append(toIndentedString(items)).append("\n");
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

