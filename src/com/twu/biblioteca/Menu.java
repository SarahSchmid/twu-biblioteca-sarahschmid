package com.twu.biblioteca;

import com.twu.biblioteca.exception.BookIsAlreadyAvailableException;
import com.twu.biblioteca.exception.CheckOutException;
import com.twu.biblioteca.exception.EmptyBookListException;

import java.io.InputStream;
import java.util.List;
import java.util.Scanner;

import static com.twu.biblioteca.Book.Availability;

public class Menu {


    public String showMainMenu(Library library, InputStream inputStream) throws
            EmptyBookListException, CheckOutException, BookIsAlreadyAvailableException {
        System.out.println("What do you wanna do next? " +
                "\n[1] List of books " +
                "\n[2] Checkout book" +
                "\n[3] Return book" +
                "\n[9] Quit");
        int userInput = readUserInput(inputStream);

        switch (userInput) {
            case 1:
                return library.showBooks(Availability.AVAILABLE);
            case 2:
                proceedCheckout(library, inputStream);
            case 3:
                proceedCheckIn(library, inputStream);
            case 9:
                return "Good Bye";
            default:
                return "Please select a valid option.";
        }

    }


    public void proceedCheckout(Library library, InputStream inputStream) {
        try {
            System.out.println("Please pick a book:");
            System.out.print(library.showBooks(Availability.AVAILABLE));

            List<Book> bookList = library.getFilteredBookList(Availability.AVAILABLE);

            int userInput = readUserInput(inputStream);

            Book book = bookPicker(bookList, userInput);

            library.checkoutBook(book);

            System.out.println("Thank you! Enjoy the book");

        } catch (Exception e) {
            System.out.println("Error during checkout:\n" + e.getMessage());
        }
    }

    public void proceedCheckIn(Library library, InputStream inputStream) throws
            EmptyBookListException, CheckOutException, BookIsAlreadyAvailableException {
        System.out.println("Which book would you like to return:");
        System.out.print(library.showBooks(Availability.RESERVED));

        List<Book> bookList = library.getFilteredBookList(Availability.RESERVED);

        int userInput = readUserInput(inputStream);

        Book book = bookPicker(bookList, userInput);

        library.checkInBook(book);

    }


    public Book bookPicker(List<Book> bookList, int index) throws CheckOutException {
        index = index - 1;

        if (index > bookList.size() || index < 0) {
            throw new CheckOutException();
        }

        return bookList.get(index);
    }

    private int readUserInput(InputStream inputStream) {
        Scanner scanner = new Scanner(inputStream);
        return scanner.nextInt();
    }
}
