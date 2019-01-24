package com.twu.biblioteca;

import com.twu.biblioteca.exception.EmptyBookListException;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class LibraryTest {

    @Test (expected = EmptyBookListException.class)
    public void showBookList_should_throw_EmptyBookListException_when_there_is_no_book_in_the_library() throws Exception {
        List<Book> bookList = new ArrayList<>();
        Library library = new Library(bookList);
        library.showBookList();
    }

    @Test
    public void showBookList_should_return_one_book_when_only_one_book_is_available() throws Exception {
        List<Book> bookList = new ArrayList<>();
        bookList.add(new Book("Moby Dick"));
        Library library = new Library(bookList);
        String result = library.showBookList();

        assertEquals("Moby Dick\n", result);
    }


    @Test
    public void showBookList_should_return_multiple_books_when_more_than_one_book_is_available() throws Exception {
        List<Book> bookList = new ArrayList<>();
        bookList.add(new Book("Moby Dick"));
        bookList.add(new Book("Harry Potter"));
        bookList.add(new Book("Lord of the Ring"));

        Library library = new Library(bookList);
        String result = library.showBookList();

        assertEquals("Moby Dick\nHarry Potter\nLord of the Ring\n", result);
    }
}