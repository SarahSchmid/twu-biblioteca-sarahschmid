package com.twu.biblioteca;

public class Librarian extends User {


    public Librarian(String password) {
        super(password, Role.LIBRARIAN);
    }
}
