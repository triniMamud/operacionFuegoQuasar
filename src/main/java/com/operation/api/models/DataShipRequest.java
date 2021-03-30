package com.operation.api.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * DataShipRequest
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen")
@Builder
public class DataShipRequest   {
  @JsonProperty("satellites")
  @Valid
  private List<SatelliteRequest> satellites = null;

  public DataShipRequest satellites(List<SatelliteRequest> satellites) {
    this.satellites = satellites;
    return this;
  }

  public DataShipRequest addSatellitesItem(SatelliteRequest satellitesItem) {
    if (this.satellites == null) {
      this.satellites = new ArrayList<SatelliteRequest>();
    }
    this.satellites.add(satellitesItem);
    return this;
  }

  /**
   * Get satellites
   * @return satellites
   **/
  @Schema(description = "")
      @Valid
    public List<SatelliteRequest> getSatellites() {
    return satellites;
  }

  public void setSatellites(List<SatelliteRequest> satellites) {
    this.satellites = satellites;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DataShipRequest dataShipRequest = (DataShipRequest) o;
    return Objects.equals(this.satellites, dataShipRequest.satellites);
  }

  @Override
  public int hashCode() {
    return Objects.hash(satellites);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DataShipRequest {\n");
    
    sb.append("    satellites: ").append(toIndentedString(satellites)).append("\n");
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
