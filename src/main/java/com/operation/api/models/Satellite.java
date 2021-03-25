package com.operation.api.models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import models.Position;

@Builder
@Getter
@Setter
public class Satellite {
    private Position position;
    private float distance;

}
