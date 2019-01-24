package com.twu.biblioteca;

import com.twu.biblioteca.exception.EmptyBookListException;

import java.util.List;

public class Library {

    private List<String> bookList;


    public void showBookList() throws EmptyBookListException {

        if (bookList == null || bookList.isEmpty()) {
            throw new EmptyBookListException();
        }

    }
}
