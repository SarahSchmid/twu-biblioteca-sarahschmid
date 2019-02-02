package com.twu.biblioteca;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

public class LibrarianMenuTest {

    @Test
    public void showLibrarianMenu_should_show_a_list_of_the_checked_out_items() {
        LibrarianMenu librarianMenu = new LibrarianMenu();
        Library library = mock(Library.class);

        String input = "1";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());

        String result = librarianMenu.showLibrarianMenu(library, inputStream);

        assertEquals("placeholder", result);
    }
}