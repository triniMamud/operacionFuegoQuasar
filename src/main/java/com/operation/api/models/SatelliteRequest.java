package com.operation.api.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;

import java.util.ArrayList;
import java.util.Objects;

/**
 * SatelliteRequest
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen")


public class SatelliteRequest   {
  @JsonProperty("name")
  private String name = null;

  @JsonProperty("distance")
  private Float distance = null;

  @JsonProperty("message")
  private ArrayList<String> message = null;

  public SatelliteRequest name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Get name
   * @return name
   **/
  @Schema(description = "")
  
    public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public SatelliteRequest distance(Float distance) {
    this.distance = distance;
    return this;
  }

  /**
   * Get distance
   * @return distance
   **/
  @Schema(description = "")
  
    public Float getDistance() {
    return distance;
  }

  public void setDistance(Float distance) {
    this.distance = distance;
  }

  public SatelliteRequest message(ArrayList<String> message) {
    this.message = message;
    return this;
  }

  /**
   * Get message
   * @return message
   **/
  @Schema(description = "")
  
    public ArrayList<String> getMessage() {
    return message;
  }

  public void setMessage(ArrayList<String> message) {
    this.message = message;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SatelliteRequest satelliteRequest = (SatelliteRequest) o;
    return Objects.equals(this.name, satelliteRequest.name) &&
        Objects.equals(this.distance, satelliteRequest.distance) &&
        Objects.equals(this.message, satelliteRequest.message);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, distance, message);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SatelliteRequest {\n");
    
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    distance: ").append(toIndentedString(distance)).append("\n");
    sb.append("    message: ").append(toIndentedString(message)).append("\n");
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
