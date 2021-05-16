package com.epam.webdev.airline.service.exception;

public class PlaneGetException extends Exception {
    public PlaneGetException() {
        super();
    }

    public PlaneGetException(String message) {
        super(message);
    }

    public PlaneGetException(String message, Throwable cause) {
        super(message, cause);
    }

    public PlaneGetException(Throwable cause) {
        super(cause);
    }
}
