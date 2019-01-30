package com.twu.biblioteca;

import com.twu.biblioteca.exception.BookValidationException;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
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

        when(library.showBooks(Availability.AVAILABLE)).thenReturn("this is a book list");

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

        InputStream inputStream = provideInput("9");

        String result = menu.showMainMenu(library, inputStream);

        assertEquals("Good Bye", result);

    }

    @Test(expected = BookValidationException.class)
    public void bookPicker_should_throw_a_CheckOutException_when_the_book_is_not_available() throws Exception {
        Menu menu = new Menu();

        List<Book> bookList = new ArrayList<>();
        bookList.add(new Book("Moby Dick", "Herman Melville", 1851, Availability.AVAILABLE));

        menu.bookPicker(bookList, 5);
    }

    @Test
    public void bookPicker_should_return_the_correct_book_from_the_booklist() throws Exception {
        Menu menu = new Menu();
        Book expected = new Book("Harry Potter", "J.K. Rowling", 1997, Availability.AVAILABLE);

        List<Book> bookList = new ArrayList<>();
        bookList.add(new Book("Moby Dick", "Herman Melville", 1851, Availability.AVAILABLE));
        bookList.add(expected);
        Book result = menu.bookPicker(bookList, 2);

        assertSame(result, expected);
    }

    @Test
    public void proceedBookCheckout_should_checkout_the_chosen_book(){
        Menu menu = new Menu();
        List<Book> bookList = new ArrayList<>();
        bookList.add(new Book("Moby Dick", "Herman Melville", 1851, Availability.AVAILABLE));
        Book expected = new Book("Harry Potter", "J.K. Rowling", 1997, Availability.AVAILABLE);
        bookList.add(expected);
        Library library = new Library(bookList);

        InputStream inputStream = provideInput("2");

        menu.proceedBookCheckout(library, inputStream);

        assertSame(expected.getAvailability(), Availability.RESERVED);

    }

    @Test
    public void proceedBookCheckIn_should_return_the_chosen_book() {
        Menu menu = new Menu();
        List<Book> bookList = new ArrayList<>();
        bookList.add(new Book("Moby Dick", "Herman Melville", 1851, Availability.RESERVED));
        Book expected = new Book("Harry Potter", "J.K. Rowling", 1997, Availability.RESERVED);
        bookList.add(expected);
        Library library = new Library(bookList);

        InputStream inputStream = provideInput("2");

        menu.proceedBookCheckIn(library, inputStream);

        assertSame(expected.getAvailability(), Availability.AVAILABLE);
    }
}