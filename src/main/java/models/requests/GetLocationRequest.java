package models.requests;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import models.Position;

@Getter
@Setter
@Builder
public class GetLocationRequest {
    private float[] distances;
}

