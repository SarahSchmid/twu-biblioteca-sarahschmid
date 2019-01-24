package com.twu.biblioteca;

import java.util.Arrays;

public class BibliotecaApp {

    public static void main(String[] args) throws Exception {

        Book[] bookList = {
                new Book("Lord ot the Rings: Fellowship of the Ring"),
                new Book("Lord ot the Rings: The Two Towers"),
                new Book("Lord ot the Rings: The Return of the King"),
                new Book("Bible")
        };
        Library library = new Library(Arrays.asList(bookList));

        Welcome welcome = new Welcome(System.out);
        welcome.showWelcomeMessage();
        System.out.println(library.showBookList());

    }
}
