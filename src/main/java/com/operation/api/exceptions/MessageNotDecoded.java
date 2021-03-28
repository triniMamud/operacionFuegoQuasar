package com.operation.api.exceptions;

public class MessageNotDecoded extends RuntimeException {
    public MessageNotDecoded() {
        super("The message couldn't be decoded with the information given");
    }
}
