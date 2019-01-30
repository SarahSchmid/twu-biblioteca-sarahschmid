package com.twu.biblioteca.exception;

public class RatingIsNotValidException extends Exception {

    private final static String message = "The rating is not valid";

    public RatingIsNotValidException() {
        super(message);
    }
}
