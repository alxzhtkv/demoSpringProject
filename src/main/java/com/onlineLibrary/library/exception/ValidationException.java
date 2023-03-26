package com.onlineLibrary.library.exception;

public class ValidationException extends Exception{
    private String message;

    public ValidationException(String message) {
    }

    public String getMessage() {
        return message;
    }
}
