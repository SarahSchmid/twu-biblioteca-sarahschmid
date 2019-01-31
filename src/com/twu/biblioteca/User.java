package com.twu.biblioteca;

public class User {

    private Role role;

    private String libraryNumber;
    private String password;


    public User(String libraryNumber, String password, Role role) {
        this.libraryNumber = libraryNumber;
        this.password = password;
        this.role = role;
    }
}
