package com.realdolmen.backend.advice.exception;

public class CustomExceptionHandler extends Exception {
    public CustomExceptionHandler(String message) {
        super(message);
    }
}