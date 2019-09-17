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

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModelProperty;

/**
 * PendingAssignmentData
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-09-13T14:25:40.305+02:00")
public class PendingAssignmentData {
    @JsonProperty("pendingUserData")
    private PendingUserData pendingUserData = null;

    @JsonProperty("pendingGroupData")
    private PendingGroupData pendingGroupData = null;

  @JsonProperty("roomId")
  private Long roomId = null;

  /**
   * Acceptance state: * &#x60;ACCEPTED&#x60; * &#x60;WAITING&#x60; * &#x60;DENIED&#x60;
   */
  public enum StateEnum {
    ACCEPTED("ACCEPTED"),
    
    WAITING("WAITING"),
    
    DENIED("DENIED");

    private String value;

    StateEnum(String value) {
      this.value = value;
    }

    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static StateEnum fromValue(String text) {
      for (StateEnum b : StateEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }

  @JsonProperty("state")
  private StateEnum state = null;

  @JsonProperty("userId")
  private Long userId = null;

  @JsonProperty("groupId")
  private Long groupId = null;

    public PendingAssignmentData pendingUserData(PendingUserData pendingUserData) {
        this.pendingUserData = pendingUserData;
        return this;
    }

    /**
     * Information about pending users
     *
     * @return pendingUserData
     **/
    @ApiModelProperty(required = true, value = "Information about pending users")
    public PendingUserData getPendingUserData() {
        return pendingUserData;
    }

    public void setPendingUserData(PendingUserData pendingUserData) {
        this.pendingUserData = pendingUserData;
    }

    public PendingAssignmentData pendingGroupData(PendingGroupData pendingGroupData) {
        this.pendingGroupData = pendingGroupData;
        return this;
    }

    /**
     * Information about group with pending assignment option
     *
     * @return pendingGroupData
     **/
    @ApiModelProperty(required = true, value = "Information about group with pending assignment option")
    public PendingGroupData getPendingGroupData() {
        return pendingGroupData;
    }

    public void setPendingGroupData(PendingGroupData pendingGroupData) {
        this.pendingGroupData = pendingGroupData;
    }

  public PendingAssignmentData roomId(Long roomId) {
    this.roomId = roomId;
    return this;
  }

   /**
   * Room ID
   * @return roomId
  **/
  @ApiModelProperty(required = true, value = "Room ID")
  public Long getRoomId() {
    return roomId;
  }

  public void setRoomId(Long roomId) {
    this.roomId = roomId;
  }

  public PendingAssignmentData state(StateEnum state) {
    this.state = state;
    return this;
  }

   /**
   * Acceptance state: * &#x60;ACCEPTED&#x60; * &#x60;WAITING&#x60; * &#x60;DENIED&#x60;
   * @return state
  **/
  @ApiModelProperty(example = "ACCEPTED", required = true, value = "Acceptance state: * `ACCEPTED` * `WAITING` * `DENIED`")
  public StateEnum getState() {
    return state;
  }

  public void setState(StateEnum state) {
    this.state = state;
  }

  public PendingAssignmentData userId(Long userId) {
      this.userId = userId;
      return this;
  }

    /**
     * &#x60;DEPRECATED&#x60;: Unique identifier for the user Please use &#x60;id&#x60; from &#x60;pendingUserData&#x60; instead.  [Deprecated since version 4.2.0]
     *
     * @return userId
     **/
    @ApiModelProperty(value = "`DEPRECATED`: Unique identifier for the user Please use `id` from `pendingUserData` instead.  [Deprecated since version 4.2.0]")
  public Long getUserId() {
    return userId;
  }

  public void setUserId(Long userId) {
    this.userId = userId;
  }

  public PendingAssignmentData groupId(Long groupId) {
      this.groupId = groupId;
      return this;
  }

    /**
     * &#x60;DEPRECATED&#x60;: Unique identifier for the group Please use &#x60;id&#x60; from &#x60;pendingGroupData&#x60; instead.  [Deprecated since version 4.2.0]
     *
     * @return groupId
     **/
    @ApiModelProperty(value = "`DEPRECATED`: Unique identifier for the group Please use `id` from `pendingGroupData` instead.  [Deprecated since version 4.2.0]")
  public Long getGroupId() {
    return groupId;
    }

    public void setGroupId(Long groupId) {
    this.groupId = groupId;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PendingAssignmentData pendingAssignmentData = (PendingAssignmentData) o;
      return Objects.equals(this.pendingUserData, pendingAssignmentData.pendingUserData) &&
          Objects.equals(this.pendingGroupData, pendingAssignmentData.pendingGroupData) &&
          Objects.equals(this.roomId, pendingAssignmentData.roomId) &&
          Objects.equals(this.state, pendingAssignmentData.state) &&
        Objects.equals(this.userId, pendingAssignmentData.userId) &&
        Objects.equals(this.groupId, pendingAssignmentData.groupId);
  }

    @Override
    public int hashCode() {
        return Objects.hash(pendingUserData, pendingGroupData, roomId, state, userId, groupId);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
      sb.append("class PendingAssignmentData {\n");

      sb.append("    pendingUserData: ").append(toIndentedString(pendingUserData)).append("\n");
      sb.append("    pendingGroupData: ").append(toIndentedString(pendingGroupData)).append("\n");
      sb.append("    roomId: ").append(toIndentedString(roomId)).append("\n");
      sb.append("    state: ").append(toIndentedString(state)).append("\n");
    sb.append("    userId: ").append(toIndentedString(userId)).append("\n");
    sb.append("    groupId: ").append(toIndentedString(groupId)).append("\n");
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

