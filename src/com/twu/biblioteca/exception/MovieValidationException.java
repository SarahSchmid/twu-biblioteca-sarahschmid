package com.twu.biblioteca.exception;

public class MovieValidationException extends Exception {

    private final static String message = "That is not a valid movie";

    public MovieValidationException() {
        super(message);
    }
}
