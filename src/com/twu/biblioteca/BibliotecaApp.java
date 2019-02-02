package com.twu.biblioteca;

public class BibliotecaApp {

    public static void main(String[] args) throws Exception {
        Library library = new Library();
        Welcome welcome = new Welcome(System.out);
        MemberMenu memberMenu = new MemberMenu();

        welcome.showWelcomeMessage();
        welcome.showLoginOptionMessage();

        System.out.print(memberMenu.showMemberMenu(library, System.in));

    }
}