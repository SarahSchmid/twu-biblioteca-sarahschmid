package com.twu.biblioteca;

public class Librarian extends User {


    public Librarian(String password) {
        super(password, Role.LIBRARIAN);
    }

    public boolean login(String password) {
        return super.getPassword().equals(password);
    }
}
