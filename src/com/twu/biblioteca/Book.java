package com.twu.biblioteca;

public class Book {

    private String title;

    public Book(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return title;
    }
}
