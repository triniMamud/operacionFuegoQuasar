package com.operation.api.controller;

import com.operation.api.models.DataShipRequest;
import com.operation.api.models.DataShipResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.operation.api.models.GetMessageRequest;
import com.operation.api.models.Position;
import com.operation.api.requirements.implementations.ReqGetLocation;
import com.operation.api.requirements.implementations.ReqGetMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen")
@RestController
public class TopsecretApiController implements TopsecretApi {

    private static final Logger log = LoggerFactory.getLogger(TopsecretApiController.class);
    private final ObjectMapper objectMapper;
    private final HttpServletRequest request;

    @Autowired
    ReqGetLocation reqGetLocation;
    @Autowired
    ReqGetMessage reqGetMessage;

    @org.springframework.beans.factory.annotation.Autowired
    public TopsecretApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    @Override
    public ResponseEntity<DataShipResponse> obtainDataShip(@Valid DataShipRequest body) {
        String shipMessage = null;
        Position shipPosition = Position.builder().build();

        GetMessageRequest getMessageRequest = GetMessageRequest
                .builder()
                .kenobiMessage(body.getSatellites().get(0).getMessage())
                .skywalkerMessage(body.getSatellites().get(1).getMessage())
                .satoMessage(body.getSatellites().get(2).getMessage())
                .build();

        Float[] distances = {
                body.getSatellites().get(0).getDistance(),
                body.getSatellites().get(1).getDistance(),
                body.getSatellites().get(2).getDistance(),
        };

        shipMessage = reqGetMessage.ejecutar(getMessageRequest);
        shipPosition = reqGetLocation.ejecutar(distances);

        DataShipResponse dataShipResponse = DataShipResponse.builder().message(shipMessage).position(shipPosition).build();

        if (dataShipResponse == null)
            return ResponseEntity.status(404).build();

        return ResponseEntity.ok(dataShipResponse);
    }
}
