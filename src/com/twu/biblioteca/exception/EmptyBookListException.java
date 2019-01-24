package com.twu.biblioteca.exception;

public class EmptyBookListException extends Exception {

    private final static String message = "The booklist is empty";

    public EmptyBookListException() {
        super(message);
    }
}
