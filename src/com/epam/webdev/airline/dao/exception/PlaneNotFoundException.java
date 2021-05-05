package com.epam.webdev.airline.dao.exception;

public class PlaneNotFoundException extends Exception {
    public PlaneNotFoundException() {
        super();
    }

    public PlaneNotFoundException(String message) {
        super(message);
    }

    public PlaneNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public PlaneNotFoundException(Throwable cause) {
        super(cause);
    }
}
