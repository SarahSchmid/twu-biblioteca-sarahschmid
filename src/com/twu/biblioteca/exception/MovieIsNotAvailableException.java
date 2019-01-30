package com.twu.biblioteca.exception;

public class MovieIsNotAvailableException extends Exception {
    private final static String message = "Sorry, that movie is not available!";

    public MovieIsNotAvailableException() {
        super(message);
    }

}
