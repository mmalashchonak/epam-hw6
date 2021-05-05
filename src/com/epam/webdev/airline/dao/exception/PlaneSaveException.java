package com.epam.webdev.airline.dao.exception;

public class PlaneSaveException extends Exception {
    public PlaneSaveException() {
        super();
    }

    public PlaneSaveException(String message) {
        super(message);
    }

    public PlaneSaveException(String message, Throwable cause) {
        super(message, cause);
    }

    public PlaneSaveException(Throwable cause) {
        super(cause);
    }
}
