package com.operation.api.models;

public class SkywalkerSatellite extends Satellite {
    public SkywalkerSatellite(float distance){
        super(new Position((float)100,(float)-100), distance);
    }
}
