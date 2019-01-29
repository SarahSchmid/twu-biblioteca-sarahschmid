package com.twu.biblioteca;

import com.twu.biblioteca.exception.CheckOutException;
import com.twu.biblioteca.exception.EmptyBookListException;

import java.util.List;

import static com.twu.biblioteca.Book.Availability;

public class Library {

    private List<Book> bookList;

    public Library(List<Book> bookList) {
        this.bookList = bookList;
    }


    public String showBooks(Availability availability) throws EmptyBookListException {
        if(isBookListEmpty()) {
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

    public void checkoutBook(Book book) throws CheckOutException {
        Availability availability = book.getAvailability();
        if (availability == Availability.RESERVED){
            throw new CheckOutException();
        }

        book.setAvailability(Availability.RESERVED);

    }

    private boolean isBookListEmpty() {
        return bookList == null || bookList.isEmpty();
    }

    public List<Book> getBookList() {
        return bookList;
    }
}
