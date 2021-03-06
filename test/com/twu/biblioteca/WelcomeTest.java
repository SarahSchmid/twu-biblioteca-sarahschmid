package com.twu.biblioteca;

import org.junit.Test;
import org.mockito.Mockito;

import java.io.PrintStream;


public class WelcomeTest {
    private PrintStream stream = Mockito.mock(PrintStream.class);

    @Test
    public void welcome_message_is_shown_on_startup() {
        Welcome welcome = new Welcome(stream);
        welcome.showWelcomeMessage();

        Mockito.verify(stream).println("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!");
    }
}