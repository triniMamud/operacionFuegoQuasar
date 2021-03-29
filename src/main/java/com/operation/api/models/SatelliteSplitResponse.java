package com.operation.api.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

/**
 * SatelliteSplitResponse
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen")
@Getter
@Setter
@Builder
public class SatelliteSplitResponse   {
  @JsonProperty("position")
  private SatelliteRequest position = null;

  @JsonProperty("message")
  private String message = null;

  public SatelliteSplitResponse position(SatelliteRequest position) {
    this.position = position;
    return this;
  }
}
