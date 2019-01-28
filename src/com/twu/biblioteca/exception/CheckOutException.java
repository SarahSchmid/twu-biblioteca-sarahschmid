package com.twu.biblioteca.exception;

public class CheckOutException extends Exception {

    private final static String message = "The book is already reserved.";

    public CheckOutException() {
        super(message);
    }
}
