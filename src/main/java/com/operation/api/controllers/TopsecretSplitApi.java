/**
 * NOTE: This class is auto generated by the swagger code generator program (3.0.25).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package com.operation.api.controllers;

import com.operation.api.models.DataShipResponse;
import com.operation.api.models.SatelliteSplitRequest;
import com.operation.api.models.SatelliteSplitResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-03-29T04:34:03.985Z[GMT]")
@Validated
public interface TopsecretSplitApi {

    @Operation(summary = "obtains the location and the emited message of the ship", description = "", tags={  })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Ok", content = @Content(schema = @Schema(implementation = DataShipResponse.class))),
        
        @ApiResponse(responseCode = "404", description = "The message or the possition couldn't be determinated") })
    @RequestMapping(value = "/topsecret_split",
        produces = { "aplication/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<DataShipResponse> obtainSplitDataShip();


    @Operation(summary = "receives different parts of the message", description = "", tags={  })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Ok", content = @Content(schema = @Schema(implementation = SatelliteSplitResponse.class))) })
    @RequestMapping(value = "/topsecret_split/{satellite_name}",
        produces = { "aplication/json" }, 
        consumes = { "aplication/json" }, 
        method = RequestMethod.POST)
    ResponseEntity<SatelliteSplitResponse> receiveDataShip(@Parameter(in = ParameterIn.PATH, description = "satellite to update", required=true, schema=@Schema()) @PathVariable("satellite_name") String satelliteName, @Parameter(in = ParameterIn.DEFAULT, description = "", schema=@Schema()) @Valid @RequestBody SatelliteSplitRequest body);

}

