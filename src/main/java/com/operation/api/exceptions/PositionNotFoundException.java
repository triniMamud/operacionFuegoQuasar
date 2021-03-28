package com.operation.api.exceptions;

public class PositionNotFoundException extends RuntimeException {
    public PositionNotFoundException(){
        super("The position couldn't be found with the information provided");
    }
}
