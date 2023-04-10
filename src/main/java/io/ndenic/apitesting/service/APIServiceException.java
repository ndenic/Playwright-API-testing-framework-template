package io.ndenic.apitesting.service;

public class APIServiceException extends RuntimeException {
    public APIServiceException(String message) {
        super(message);
    }

    public APIServiceException(String message, Throwable cause) {
        super(message, cause);
    }

}