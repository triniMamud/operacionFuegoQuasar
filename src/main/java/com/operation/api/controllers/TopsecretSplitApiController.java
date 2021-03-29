package com.operation.api.controllers;

import com.operation.api.models.DataShipResponse;
import com.operation.api.models.SatelliteSplitRequest;
import com.operation.api.models.SatelliteSplitResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-03-29T04:34:03.985Z[GMT]")
@RestController
public class TopsecretSplitApiController implements TopsecretSplitApi {

    private static final Logger log = LoggerFactory.getLogger(TopsecretSplitApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public TopsecretSplitApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    @Override
    public ResponseEntity<DataShipResponse> obtainSplitDataShip() {
        return null;
    }

    @Override
    public ResponseEntity<SatelliteSplitResponse> receiveDataShip(String satelliteName, @Valid SatelliteSplitRequest body) {
        return null;
    }
}
