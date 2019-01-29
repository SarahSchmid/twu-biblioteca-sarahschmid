package com.twu.biblioteca;

import com.twu.biblioteca.exception.CheckOutException;
import com.twu.biblioteca.exception.EmptyBookListException;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

public class LibraryTest {

    @Test (expected = EmptyBookListException.class)
    public void showBooks_should_throw_EmptyBookListException_when_there_is_no_book_in_the_library() throws Exception {
        List<Book> bookList = new ArrayList<>();
        Library library = new Library(bookList);
        library.showBooks(Book.Availability.AVAILABLE);
    }

    @Test
    public void showBooks_should_return_one_book_when_only_one_book_is_available() throws Exception {
        List<Book> bookList = new ArrayList<>();
        bookList.add(new Book("Moby Dick", "Herman Melville", 1851, Book.Availability.AVAILABLE));
        Library library = new Library(bookList);
        String result = library.showBooks(Book.Availability.AVAILABLE);

        assertEquals("|Moby Dick                                         |Herman Melville     |1851|\n", result);
    }


    @Test
    public void showBooks_should_return_multiple_books_when_more_than_one_book_is_available() throws Exception {
        List<Book> bookList = new ArrayList<>();
        bookList.add(new Book("Moby Dick", "Herman Melville", 1851, Book.Availability.AVAILABLE));
        bookList.add(new Book("Harry Potter", "J.K. Rowling", 1997, Book.Availability.AVAILABLE));
        bookList.add(new Book("Lord of the Ring", "J.R.R. Tolkien", 1954, Book.Availability.AVAILABLE));

        Library library = new Library(bookList);
        String result = library.showBooks(Book.Availability.AVAILABLE);

        String expected =
                "|Moby Dick                                         |Herman Melville     |1851|\n" +
                "|Harry Potter                                      |J.K. Rowling        |1997|\n" +
                "|Lord of the Ring                                  |J.R.R. Tolkien      |1954|\n";

        assertEquals(expected, result);
    }

    @Test
    public void showBooks_should_only_return_the_books_that_are_available_for_checkout() throws Exception {
        List<Book> bookList = new ArrayList<>();
        bookList.add(new Book("Moby Dick", "Herman Melville", 1851, Book.Availability.AVAILABLE));
        bookList.add(new Book("Harry Potter", "J.K. Rowling", 1997, Book.Availability.AVAILABLE));
        bookList.add(new Book("Lord of the Ring", "J.R.R. Tolkien", 1954, Book.Availability.RESERVED));

        Library library = new Library(bookList);
        String result = library.showBooks(Book.Availability.AVAILABLE);

        String expected =
                        "|Moby Dick                                         |Herman Melville     |1851|\n" +
                        "|Harry Potter                                      |J.K. Rowling        |1997|\n";

        assertEquals(expected, result);
    }

    @Test
    public void showBooks_should_only_return_the_books_that_are_already_reserved() throws EmptyBookListException {
        List<Book> bookList = new ArrayList<>();
        bookList.add(new Book("Moby Dick", "Herman Melville", 1851, Book.Availability.AVAILABLE));
        bookList.add(new Book("Harry Potter", "J.K. Rowling", 1997, Book.Availability.RESERVED));
        bookList.add(new Book("Lord of the Ring", "J.R.R. Tolkien", 1954, Book.Availability.RESERVED));

        Library library = new Library(bookList);
        String result = library.showBooks(Book.Availability.RESERVED);

        String expected =
                        "|Harry Potter                                      |J.K. Rowling        |1997|\n" +
                        "|Lord of the Ring                                  |J.R.R. Tolkien      |1954|\n";

        assertEquals(expected, result);
    }

    @Test
    public void checkoutBook_should_set_the_availability_of_the_chosen_book_to_reserved() throws Exception {
        Book book = new Book("Moby Dick", "Herman Melville", 1851);

        List<Book> bookList = new ArrayList<>();
        bookList.add(book);

        Library library = new Library(bookList);
        library.checkoutBook(book);

        assertSame(book.getAvailability(), Book.Availability.RESERVED);
    }

    @Test (expected = CheckOutException.class)
    public void checkoutBook_should_throw_CheckOutException_if_its_already_reserved() throws Exception {
        Book book = new Book("Moby Dick", "Herman Melville", 1851, Book.Availability.RESERVED);

        List<Book> bookList = new ArrayList<>();
        bookList.add(book);
        Library library = new Library(bookList);

        library.checkoutBook(book);
    }
}