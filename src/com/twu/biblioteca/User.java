package com.twu.biblioteca;

public class User {

    private Role role;

    private String password;


    public User(String password, Role role) {
        this.password = password;
        this.role = role;
    }

    public String getPassword() {
        return password;
    }
}
