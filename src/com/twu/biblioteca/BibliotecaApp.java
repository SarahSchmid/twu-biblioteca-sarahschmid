package com.twu.biblioteca;

public class BibliotecaApp {

    public static void main(String[] args) throws Exception {
        Library library = new Library();
        Welcome welcome = new Welcome(System.out);
        LoginMenu loginMenu = new LoginMenu();
        LibrarianMenu librarianMenu = new LibrarianMenu();
        MemberMenu memberMenu = new MemberMenu();

        welcome.showWelcomeMessage();
        String loginResponse = loginMenu.loginUser(System.in);

        switch (loginResponse){
            case "Librarian":
                System.out.print(librarianMenu.showLibrarianMenu(library, System.in));
            case "Member":
                System.out.print(memberMenu.showMemberMenu(library, System.in));

        }

    }
}