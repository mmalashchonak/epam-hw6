package com.epam.webdev.airline.source.file.exception;

public class FileSaveException extends Exception {
    public FileSaveException() {
        super();
    }

    public FileSaveException(String message) {
        super(message);
    }

    public FileSaveException(String message, Throwable cause) {
        super(message, cause);
    }

    public FileSaveException(Throwable cause) {
        super(cause);
    }
}
