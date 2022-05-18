package com.example.mybank.exceptions;

public class DontInputPinCodeWhileAccBlockException extends RuntimeException {
    public DontInputPinCodeWhileAccBlockException(String message) {
        super(message);
    }
}