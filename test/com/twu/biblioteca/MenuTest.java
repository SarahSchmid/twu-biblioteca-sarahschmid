package com.twu.biblioteca;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class MenuTest {

    @Test
    public void showMainMenu_should_take_user_input_to_display_the_booklist() throws Exception {
        Library library = mock(Library.class);

        String input = "1";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());

        Menu menu = new Menu();
        when(library.showBookList()).thenReturn("this is a book list");

        String result = menu.showMainMenu(library, inputStream);

        assertEquals("this is a book list", result);
    }
}