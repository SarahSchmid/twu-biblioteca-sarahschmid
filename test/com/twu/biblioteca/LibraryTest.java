package com.twu.biblioteca;

import com.twu.biblioteca.exception.EmptyBookListException;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class LibraryTest {

    @Test (expected = EmptyBookListException.class)
    public void showAllBooks_should_throw_EmptyBookListException_when_there_is_no_book_in_the_library() throws Exception {
        List<Book> bookList = new ArrayList<>();
        Library library = new Library(bookList);
        library.showAllBooks();
    }

    @Test
    public void showAllBooks_should_return_one_book_when_only_one_book_is_available() throws Exception {
        List<Book> bookList = new ArrayList<>();
        bookList.add(new Book("Moby Dick", "Herman Melville", 1851, Book.Availability.AVAILABLE));
        Library library = new Library(bookList);
        String result = library.showAllBooks();

        assertEquals("|Moby Dick                                         |Herman Melville     |1851|\n", result);
    }


    @Test
    public void showAllBooks_should_return_multiple_books_when_more_than_one_book_is_available() throws Exception {
        List<Book> bookList = new ArrayList<>();
        bookList.add(new Book("Moby Dick", "Herman Melville", 1851, Book.Availability.AVAILABLE));
        bookList.add(new Book("Harry Potter", "J.K. Rowling", 1997, Book.Availability.AVAILABLE));
        bookList.add(new Book("Lord of the Ring", "J.R.R. Tolkien", 1954, Book.Availability.AVAILABLE));

        Library library = new Library(bookList);
        String result = library.showAllBooks();

        String expected =
                "|Moby Dick                                         |Herman Melville     |1851|\n" +
                "|Harry Potter                                      |J.K. Rowling        |1997|\n" +
                "|Lord of the Ring                                  |J.R.R. Tolkien      |1954|\n";

        assertEquals(expected, result);
    }

    @Test
    public void showAvailableBooks_should_only_return_the_books_that_are_available_for_checkout() throws Exception {
        List<Book> bookList = new ArrayList<>();
        bookList.add(new Book("Moby Dick", "Herman Melville", 1851, Book.Availability.AVAILABLE));
        bookList.add(new Book("Harry Potter", "J.K. Rowling", 1997, Book.Availability.AVAILABLE));
        bookList.add(new Book("Lord of the Ring", "J.R.R. Tolkien", 1954, Book.Availability.RESERVED));

        Library library = new Library(bookList);
        String result = library.showAvailableBooks();

        String expected =
                        "|Moby Dick                                         |Herman Melville     |1851|\n" +
                        "|Harry Potter                                      |J.K. Rowling        |1997|\n";

        assertEquals(expected, result);
    }
}