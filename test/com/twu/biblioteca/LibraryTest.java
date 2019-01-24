package com.twu.biblioteca;

import com.twu.biblioteca.exception.EmptyBookListException;
import org.junit.Test;


public class LibraryTest {

    @Test (expected = EmptyBookListException.class)
    public void showBookList_should_throw_EmptyBookListException_when_there_is_no_book_in_the_library() throws Exception {
        Library library = new Library();
        library.showBookList();
    }
}