package com.operation.api.exceptions;

public class MessageIncompleteException extends RuntimeException{
    public MessageIncompleteException() {
        super("The message was decoded incomplete");
    }
}
