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
 * A fileContent object
 */
@ApiModel(description = "A fileContent object")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-09-13T14:06:08.665+02:00")
public class FileContents {
  @JsonProperty("parent")
  private ch.cyberduck.core.storegate.io.swagger.client.model.File parent = null;

  @JsonProperty("rootPath")
  private String rootPath = null;

  @JsonProperty("totalRowCount")
  private Integer totalRowCount = null;

  @JsonProperty("files")
  private List<ch.cyberduck.core.storegate.io.swagger.client.model.File> files = null;

  public FileContents parent(ch.cyberduck.core.storegate.io.swagger.client.model.File parent) {
    this.parent = parent;
    return this;
  }

   /**
   * The parent resourceItem, if included.
   * @return parent
  **/
  @ApiModelProperty(value = "The parent resourceItem, if included.")
  public ch.cyberduck.core.storegate.io.swagger.client.model.File getParent() {
    return parent;
  }

  public void setParent(ch.cyberduck.core.storegate.io.swagger.client.model.File parent) {
    this.parent = parent;
  }

  public FileContents rootPath(String rootPath) {
    this.rootPath = rootPath;
    return this;
  }

   /**
   * Root path for all items in the list.
   * @return rootPath
  **/
  @ApiModelProperty(value = "Root path for all items in the list.")
  public String getRootPath() {
    return rootPath;
  }

  public void setRootPath(String rootPath) {
    this.rootPath = rootPath;
  }

  public FileContents totalRowCount(Integer totalRowCount) {
    this.totalRowCount = totalRowCount;
    return this;
  }

   /**
   * Total number of item.
   * @return totalRowCount
  **/
  @ApiModelProperty(value = "Total number of item.")
  public Integer getTotalRowCount() {
    return totalRowCount;
  }

  public void setTotalRowCount(Integer totalRowCount) {
    this.totalRowCount = totalRowCount;
  }

  public FileContents files(List<ch.cyberduck.core.storegate.io.swagger.client.model.File> files) {
    this.files = files;
    return this;
  }

  public FileContents addFilesItem(ch.cyberduck.core.storegate.io.swagger.client.model.File filesItem) {
    if (this.files == null) {
        this.files = new ArrayList<>();
    }
    this.files.add(filesItem);
    return this;
  }

   /**
   * The list of items.
   * @return files
  **/
  @ApiModelProperty(value = "The list of items.")
  public List<ch.cyberduck.core.storegate.io.swagger.client.model.File> getFiles() {
    return files;
  }

  public void setFiles(List<ch.cyberduck.core.storegate.io.swagger.client.model.File> files) {
    this.files = files;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    FileContents fileContents = (FileContents) o;
    return Objects.equals(this.parent, fileContents.parent) &&
        Objects.equals(this.rootPath, fileContents.rootPath) &&
        Objects.equals(this.totalRowCount, fileContents.totalRowCount) &&
        Objects.equals(this.files, fileContents.files);
  }

  @Override
  public int hashCode() {
    return Objects.hash(parent, rootPath, totalRowCount, files);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class FileContents {\n");
    
    sb.append("    parent: ").append(toIndentedString(parent)).append("\n");
    sb.append("    rootPath: ").append(toIndentedString(rootPath)).append("\n");
    sb.append("    totalRowCount: ").append(toIndentedString(totalRowCount)).append("\n");
    sb.append("    files: ").append(toIndentedString(files)).append("\n");
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

