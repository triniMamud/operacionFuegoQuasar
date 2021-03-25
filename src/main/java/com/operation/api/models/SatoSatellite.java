package com.operation.api.models;

public class SatoSatellite extends Satellite {
    public  SatoSatellite (float distance){
        super(new Position((float)500, (float)100), distance);
    }
}
