package com.example.handlerexception.exception;

public class UnauthorizedException extends  RuntimeException {

    public UnauthorizedException() {
    }

    public UnauthorizedException(String message) {
        super(message);
    }
}
