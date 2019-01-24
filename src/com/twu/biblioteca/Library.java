package com.twu.biblioteca;

import com.twu.biblioteca.exception.EmptyBookListException;

import java.util.List;

public class Library {

    private List<Book> bookList;

    public Library(List<Book> bookList) {
        this.bookList = bookList;
    }

    public String showBookList() throws EmptyBookListException {

        if (bookList == null || bookList.isEmpty()) {
            throw new EmptyBookListException();
        }

        StringBuilder books = new StringBuilder();
        for (Book book : bookList) {
            books.append(book);
        }

        return books.toString();
    }
}
