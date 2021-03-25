package com.operation.api.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

/**
 * Position
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-03-25T05:21:23.623Z[GMT]")
@Getter
@Setter
@Builder
@EqualsAndHashCode(of = {"x", "y"})
public class Position   {
  @JsonProperty("x")
  private Float x = null;

  @JsonProperty("y")
  private Float y = null;

}
