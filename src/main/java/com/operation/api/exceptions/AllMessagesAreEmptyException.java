package com.operation.api.exceptions;

public class AllMessagesAreEmptyException extends RuntimeException {
    public AllMessagesAreEmptyException(){
        super("All the messages given are empty");
    }
}
