package com.twu.biblioteca;

import com.twu.biblioteca.exception.BookValidationException;
import com.twu.biblioteca.exception.EmptyBookListException;
import com.twu.biblioteca.exception.MovieValidationException;

import java.io.InputStream;
import java.util.List;

import static com.twu.biblioteca.IOHelper.readUserInput;


public class MemberMenu {

    public String showMemberMenu(Library library, InputStream inputStream) throws EmptyBookListException {
        System.out.println("What do you wanna do next? " +
                "\n[1] List of available books " +
                "\n[2] Checkout book" +
                "\n[3] Return book" +
                "\n[4] List of available movies" +
                "\n[5] Checkout movie" +
                "\n[9] Quit");
        int userInput = IOHelper.readUserInput(inputStream);

        switch (userInput) {
            case 1:
                return library.showBooks(Availability.AVAILABLE);
            case 2:
                proceedBookCheckout(library, inputStream);
                return "Thank you! Enjoy the book";
            case 3:
                proceedBookCheckIn(library, inputStream);
                return "Thank you for returning the book";
            case 4:
                return library.showMovies(Availability.AVAILABLE);
            case 5:
                proceedMovieCheckOut(library, inputStream);
                return "Thank you! Enjoy the movie";
            case 9:
                return "Good Bye";
            default:
                return "Please select a valid option.";
        }
    }

    public void proceedBookCheckout(Library library, InputStream inputStream) {
        try {
            System.out.println("Please pick a book:");
            System.out.print(library.showBooks(Availability.AVAILABLE));

            List<Book> bookList = library.getFilteredBookList(Availability.AVAILABLE);
            int userInput = readUserInput(inputStream);
            Book book = getChosenBookFromList(bookList, userInput);

            library.checkoutBook(book);
        } catch (Exception e) {
            System.out.println("Error during checkout:\n" + e.getMessage());
        }
    }

    public void proceedBookCheckIn(Library library, InputStream inputStream) {
        try {
            System.out.println("Which book would you like to return:");
            System.out.print(library.showBooks(Availability.RESERVED));

            List<Book> bookList = library.getFilteredBookList(Availability.RESERVED);
            int userInput = readUserInput(inputStream);
            Book book = getChosenBookFromList(bookList, userInput);

            library.checkInBook(book);

        } catch (Exception e) {
            System.out.println("Error during checkin:\n" + e.getMessage());
        }
    }

    private Book getChosenBookFromList(List<Book> bookList, int index) throws BookValidationException {
        index = index - 1;
        if (index > bookList.size() || index < 0) {
            throw new BookValidationException();
        }
        return bookList.get(index);
    }

    public void proceedMovieCheckOut(Library library, InputStream inputStream) {
        try {
            System.out.println("Please pick a movie:");
            System.out.print(library.showMovies(Availability.AVAILABLE));

            List<Movie> movieList = library.getFilteredMovieList(Availability.AVAILABLE);
            int userInput = readUserInput(inputStream);
            Movie movie = getChosenMovieFromList(movieList, userInput);

            library.checkOutMovie(movie);
        } catch (Exception e) {
            System.out.println("Error during checkout:\n" + e.getMessage());
        }
    }

    private Movie getChosenMovieFromList(List<Movie> movieList, int index) throws MovieValidationException {
        index = index - 1;
        if (index > movieList.size() || index < 0) {
            throw new MovieValidationException();
        }
        return movieList.get(index);
    }
}
