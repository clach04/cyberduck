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
 * UpdateSyslogConfig
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-09-13T14:25:40.305+02:00")
public class UpdateSyslogConfig {
  @JsonProperty("enabled")
  private Boolean enabled = null;

  @JsonProperty("host")
  private String host = null;

  @JsonProperty("port")
  private Integer port = null;

  /**
   * Protocol to connect to syslog server
   */
  public enum ProtocolEnum {
    TCP("TCP"),
    
    UDP("UDP");

    private String value;

    ProtocolEnum(String value) {
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
    public static ProtocolEnum fromValue(String text) {
      for (ProtocolEnum b : ProtocolEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }

  @JsonProperty("protocol")
  private ProtocolEnum protocol = null;

  @JsonProperty("logIpEnabled")
  private Boolean logIpEnabled = null;

  public UpdateSyslogConfig enabled(Boolean enabled) {
    this.enabled = enabled;
    return this;
  }

   /**
   * Is syslog enabled?
   * @return enabled
  **/
   @ApiModelProperty(example = "false", value = "Is syslog enabled?")
   public Boolean isEnabled() {
    return enabled;
  }

  public void setEnabled(Boolean enabled) {
    this.enabled = enabled;
  }

  public UpdateSyslogConfig host(String host) {
    this.host = host;
    return this;
  }

   /**
   * Syslog server (IP or FQDN)
   * @return host
  **/
  @ApiModelProperty(value = "Syslog server (IP or FQDN)")
  public String getHost() {
    return host;
  }

  public void setHost(String host) {
    this.host = host;
  }

  public UpdateSyslogConfig port(Integer port) {
    this.port = port;
    return this;
  }

   /**
   * Syslog server port
   * @return port
  **/
  @ApiModelProperty(value = "Syslog server port")
  public Integer getPort() {
    return port;
  }

  public void setPort(Integer port) {
    this.port = port;
  }

  public UpdateSyslogConfig protocol(ProtocolEnum protocol) {
    this.protocol = protocol;
    return this;
  }

   /**
   * Protocol to connect to syslog server
   * @return protocol
  **/
  @ApiModelProperty(value = "Protocol to connect to syslog server")
  public ProtocolEnum getProtocol() {
    return protocol;
  }

  public void setProtocol(ProtocolEnum protocol) {
    this.protocol = protocol;
  }

  public UpdateSyslogConfig logIpEnabled(Boolean logIpEnabled) {
    this.logIpEnabled = logIpEnabled;
    return this;
  }

   /**
    * Determines whether user’s IP address is logged.
   * @return logIpEnabled
  **/
   @ApiModelProperty(example = "false", value = "Determines whether user’s IP address is logged.")
   public Boolean isLogIpEnabled() {
    return logIpEnabled;
  }

  public void setLogIpEnabled(Boolean logIpEnabled) {
    this.logIpEnabled = logIpEnabled;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UpdateSyslogConfig updateSyslogConfig = (UpdateSyslogConfig) o;
    return Objects.equals(this.enabled, updateSyslogConfig.enabled) &&
        Objects.equals(this.host, updateSyslogConfig.host) &&
        Objects.equals(this.port, updateSyslogConfig.port) &&
        Objects.equals(this.protocol, updateSyslogConfig.protocol) &&
        Objects.equals(this.logIpEnabled, updateSyslogConfig.logIpEnabled);
  }

  @Override
  public int hashCode() {
    return Objects.hash(enabled, host, port, protocol, logIpEnabled);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UpdateSyslogConfig {\n");

      sb.append("    enabled: ").append(toIndentedString(enabled)).append("\n");
    sb.append("    host: ").append(toIndentedString(host)).append("\n");
    sb.append("    port: ").append(toIndentedString(port)).append("\n");
    sb.append("    protocol: ").append(toIndentedString(protocol)).append("\n");
    sb.append("    logIpEnabled: ").append(toIndentedString(logIpEnabled)).append("\n");
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

