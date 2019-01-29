package com.twu.biblioteca.exception;

public class CheckOutException extends Exception {

    private final static String message = "Cannot find the book";

    public CheckOutException() {
        super(message);
    }
}
