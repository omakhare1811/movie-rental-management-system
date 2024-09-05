package com.cts.exception;

public class DatabaseException extends Exception {
    public DatabaseException() {
        super("A database error occurred.");
    }

    // Constructor that accepts a custom message
    public DatabaseException(String message) {
        super(message);
    }

}
