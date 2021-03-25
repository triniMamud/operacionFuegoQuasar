package com.operation.api.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.operation.api.models.DataShipRequest;
import com.operation.api.models.DataShipResponse;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Schema;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-03-25T05:21:23.623Z[GMT]")
@RestController
public class TopsecretApiController implements TopsecretApi {

    private static final Logger log = LoggerFactory.getLogger(TopsecretApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public TopsecretApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    @Override
    @GetMapping("/")
    public ResponseEntity<String> obtainDataShip(@Parameter(in = ParameterIn.DEFAULT, description = "satellites", required=true, schema=@Schema()) @Valid @RequestBody DataShipRequest body) {

        return new ResponseEntity<String>(HttpStatus.valueOf("holaaaa"));
    }
}
