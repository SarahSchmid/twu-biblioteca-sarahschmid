package com.twu.biblioteca.exception;

public class BookIsAlreadyAvailableException extends Exception {
    private final static String message = "You cannot return an available book";

    public BookIsAlreadyAvailableException() {
        super(message);
    }
}
