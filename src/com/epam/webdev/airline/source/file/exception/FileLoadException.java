package com.epam.webdev.airline.source.file.exception;

public class FileLoadException extends Exception {
    public FileLoadException() {
        super();
    }

    public FileLoadException(String message) {
        super(message);
    }

    public FileLoadException(String message, Throwable cause) {
        super(message, cause);
    }

    public FileLoadException(Throwable cause) {
        super(cause);
    }
}
