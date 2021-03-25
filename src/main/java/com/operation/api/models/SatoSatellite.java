package com.operation.api.models;

import models.Position;

public class SatoSatellite extends Satellite {
    public  SatoSatellite (float distance){
        super(new Position(500, 100), distance);
    }
}
