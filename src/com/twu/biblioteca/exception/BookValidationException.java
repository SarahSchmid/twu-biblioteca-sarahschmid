package com.twu.biblioteca.exception;

public class BookValidationException extends Exception {

    private final static String message = "That is not a valid book";

    public BookValidationException() {
        super(message);
    }
}
