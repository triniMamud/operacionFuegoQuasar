package com.operation.api.models;

import models.Position;

public class SkywalkerSatellite extends Satellite {
    public SkywalkerSatellite(float distance){
        super(new Position(100,-100), distance);
    }
}
