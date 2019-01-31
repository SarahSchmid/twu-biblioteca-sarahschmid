package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class LibrarianTest {

    @Test
    public void login_should_return_false_if_the_password_is_incorrect() {
        Librarian librarian = new Librarian("password");

        assertFalse(librarian.login("12345"));
    }

    @Test
    public void login_should_return_true_if_the_password_is_correct() {
        Librarian librarian = new Librarian("password");

        assertTrue(librarian.login("password"));
    }
}