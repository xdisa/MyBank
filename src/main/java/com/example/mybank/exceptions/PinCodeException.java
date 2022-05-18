package com.example.mybank.exceptions;

public class PinCodeException extends RuntimeException {
    public PinCodeException(String message) {
        super(message);
    }
}