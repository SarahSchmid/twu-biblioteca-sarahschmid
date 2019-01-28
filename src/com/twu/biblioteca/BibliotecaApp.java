package com.twu.biblioteca;

import java.util.Arrays;

public class BibliotecaApp {

    public static void main(String[] args) throws Exception {

        Book[] bookList = {
                new Book("Lord ot the Rings: Fellowship of the Ring", "J.R.R. Tolkien", 1954),
                new Book("Lord ot the Rings: The Two Towers", "J.R.R. Tolkien", 1954),
                new Book("Lord ot the Rings: The Return of the King", "J.R.R. Tolkien", 1954),
                new Book("Bible", "God", 0)
        };
        Library library = new Library(Arrays.asList(bookList));

        Welcome welcome = new Welcome(System.out);
        welcome.showWelcomeMessage();

        Menu menu = new Menu();
        System.out.print(menu.showMainMenu(library, System.in));

    }
}
