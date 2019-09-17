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
 * DownloadShareList
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-09-13T14:25:40.305+02:00")
public class DownloadShareList {
  @JsonProperty("range")
  private Range range = null;

  @JsonProperty("items")
  private List<DownloadShare> items = new ArrayList<>();

  public DownloadShareList range(Range range) {
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

  public DownloadShareList items(List<DownloadShare> items) {
    this.items = items;
    return this;
  }

  public DownloadShareList addItemsItem(DownloadShare itemsItem) {
    this.items.add(itemsItem);
    return this;
  }

   /**
   * List of Download Shares
   * @return items
  **/
  @ApiModelProperty(required = true, value = "List of Download Shares")
  public List<DownloadShare> getItems() {
    return items;
  }

  public void setItems(List<DownloadShare> items) {
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
    DownloadShareList downloadShareList = (DownloadShareList) o;
    return Objects.equals(this.range, downloadShareList.range) &&
        Objects.equals(this.items, downloadShareList.items);
  }

  @Override
  public int hashCode() {
    return Objects.hash(range, items);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DownloadShareList {\n");

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

