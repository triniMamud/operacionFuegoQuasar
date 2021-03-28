package com.operation.api.exceptions;

public class InvalidRequestException extends RuntimeException {
    public InvalidRequestException() {
        super("The request given is invalid");
    }
}
