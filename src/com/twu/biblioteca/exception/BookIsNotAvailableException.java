package com.twu.biblioteca.exception;

public class BookIsNotAvailableException extends Exception {

    private final static String message = "Cannot find the chosen Book";

    public BookIsNotAvailableException() {
        super(message);
    }
}
