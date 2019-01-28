package com.twu.biblioteca;

import com.twu.biblioteca.exception.EmptyBookListException;

import java.util.List;

public class Library {

    private List<Book> bookList;

    public Library(List<Book> bookList) {
        this.bookList = bookList;
    }

    public String showAllBooks() throws EmptyBookListException {

        if (isBookListEmpty()) {
            throw new EmptyBookListException();
        }

        StringBuilder books = new StringBuilder();
        for (Book book : bookList) {
            books.append(book);
        }

        return books.toString();
    }

    public String showAvailableBooks() throws EmptyBookListException {
        if(isBookListEmpty()) {
            throw new EmptyBookListException();
        }

        StringBuilder books = new StringBuilder();
        for (Book book : bookList) {
            if (book.getAvailability() == Book.Availability.AVAILABLE) {
                books.append(book);
            }
        }

        return books.toString();
    }


    private boolean isBookListEmpty() {
        return bookList == null || bookList.isEmpty();
    }
}
