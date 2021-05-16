package com.epam.webdev.airline.service.exception;

public class PlaneAddException extends Exception {
    public PlaneAddException() {
        super();
    }

    public PlaneAddException(String message) {
        super(message);
    }

    public PlaneAddException(String message, Throwable cause) {
        super(message, cause);
    }

    public PlaneAddException(Throwable cause) {
        super(cause);
    }
}
