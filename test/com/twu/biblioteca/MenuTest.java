package com.twu.biblioteca;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class MenuTest {

    private InputStream provideInput(String input) {
        return new ByteArrayInputStream(input.getBytes());
    }

    @Test
    public void showMainMenu_should_take_user_input_to_display_the_complete_booklist() throws Exception {
        Menu menu = new Menu();
        Library library = mock(Library.class);

        InputStream inputStream = provideInput("1");

        when(library.showAllBooks()).thenReturn("this is a book list");

        String result = menu.showMainMenu(library, inputStream);

        assertEquals("this is a book list", result);
    }

    @Test
    public void showMainMenu_should_return_a_notification_when_the_input_is_invalid() throws Exception {
        Menu menu = new Menu();
        Library library = mock(Library.class);

        InputStream inputStream = provideInput("6");

        String result = menu.showMainMenu(library, inputStream);

        assertEquals("Please select a valid option.", result);
    }

    @Test
    public void showMainMenu_should_return_the_goodbye_message() throws Exception {
        Menu menu = new Menu();
        Library library = mock(Library.class);

        String input = "9";
        InputStream inputStream = provideInput("9");

        String result = menu.showMainMenu(library, inputStream);

        assertEquals("Good Bye", result);

    }



}