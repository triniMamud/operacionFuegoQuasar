package models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class Satellite {
    private Position position;
    private float distance;

}
