package com.twu.biblioteca.exception;

public class MemberNotFoundException extends Exception{

    private final static String message = "Cannot find the member";

    public MemberNotFoundException() {
        super(message);
    }
}
