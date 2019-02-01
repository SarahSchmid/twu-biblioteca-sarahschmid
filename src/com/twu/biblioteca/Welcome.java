package com.twu.biblioteca;

import java.io.PrintStream;

public class Welcome {

    private PrintStream stream;

    public Welcome(PrintStream stream) {
        this.stream = stream;
    }

    public void showWelcomeMessage() {
        stream.println("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!");
    }

    public void pickLoginOption() {
        stream.print("Please choose a login option: \n[1] Librarian\n[2] Member");
    }
}
