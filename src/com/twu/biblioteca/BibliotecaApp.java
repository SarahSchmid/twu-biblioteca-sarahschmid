package com.twu.biblioteca;

public class BibliotecaApp {

    public static void main(String[] args) throws Exception {
        Library library = new Library();
        Welcome welcome = new Welcome(System.out);
        Menu menu = new Menu();

        welcome.showWelcomeMessage();
        welcome.pickLoginOption();

        System.out.print(menu.showMainMenu(library, System.in));

    }
}