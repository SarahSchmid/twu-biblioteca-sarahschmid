package com.twu.biblioteca;

import com.twu.biblioteca.exception.BookIsAlreadyAvailableException;
import com.twu.biblioteca.exception.BookIsNotAvailableException;
import com.twu.biblioteca.exception.EmptyBookListException;

import java.util.ArrayList;
import java.util.List;


public class Library {

    private List<Book> bookList;

    public Library(List<Book> bookList) {
        this.bookList = bookList;
    }


    public String showBooks(Availability availability) throws EmptyBookListException {
        if (isBookListEmpty()) {
            throw new EmptyBookListException();
        }

        StringBuilder books = new StringBuilder();
        for (Book book : bookList) {
            if (book.getAvailability() == availability) {
                books.append(book);
            }
        }

        return books.toString();
    }

    public void checkoutBook(Book book) throws BookIsNotAvailableException {
        Availability availability = book.getAvailability();
        if (availability == Availability.RESERVED) {
            throw new BookIsNotAvailableException();
        }

        book.setAvailability(Availability.RESERVED);

    }

    public void checkInBook(Book book) throws BookIsAlreadyAvailableException {
        Availability availability = book.getAvailability();
        if (availability == Availability.AVAILABLE) {
            throw new BookIsAlreadyAvailableException();
        }

        book.setAvailability(Availability.AVAILABLE);
    }

    private boolean isBookListEmpty() {
        return bookList == null || bookList.isEmpty();
    }

    public List<Book> getFilteredBookList(Availability availability) {

        List<Book> filteredBooks = new ArrayList<>();
        for (Book book : bookList) {
            if (book.getAvailability() == availability) {
                filteredBooks.add(book);
            }
        }

        return filteredBooks;
    }
}
