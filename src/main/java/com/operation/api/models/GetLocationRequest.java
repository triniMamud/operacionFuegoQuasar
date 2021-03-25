package com.operation.api.models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
@Builder
public class GetLocationRequest {
    private ArrayList<Float> distances;
}