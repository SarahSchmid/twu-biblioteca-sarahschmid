package com.twu.biblioteca.exception;

public class BookIsNotAvailableException extends Exception {

    private final static String message = "Sorry, that book is not available!";

    public BookIsNotAvailableException() {
        super(message);
    }
}
