package com.twu.biblioteca;

public class BibliotecaApp {

    public static void main(String[] args) throws Exception {

        Library library = new Library();

        Welcome welcome = new Welcome(System.out);
        welcome.showWelcomeMessage();

        Menu menu = new Menu();
        System.out.print(menu.showMainMenu(library, System.in));

    }
}