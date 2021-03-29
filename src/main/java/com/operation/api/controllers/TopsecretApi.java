/**
 * NOTE: This class is auto generated by the swagger code generator program (3.0.25).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package com.operation.api.controllers;

import com.operation.api.models.DataShipRequest;
import com.operation.api.models.DataShipResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-03-28T02:50:56.077Z[GMT]")
@Validated
public interface TopsecretApi {

    @Operation(summary = "obtains the location and the emited message of the ship", description = "", tags={  })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Ok", content = @Content(schema = @Schema(implementation = DataShipResponse.class))),
        
        @ApiResponse(responseCode = "404", description = "The message or the possition couldn't be determinated") })
    @RequestMapping(value = "/topsecret",
        produces = { "aplication/json" }, 
        consumes = { "aplication/json" }, 
        method = RequestMethod.POST)
    ResponseEntity<DataShipResponse> obtainDataShip(@Parameter(in = ParameterIn.DEFAULT, description = "satellites", required=true, schema=@Schema()) @Valid @RequestBody DataShipRequest body);

}
