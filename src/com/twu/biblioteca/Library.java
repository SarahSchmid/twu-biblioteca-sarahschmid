package com.twu.biblioteca;

import com.twu.biblioteca.exception.BookIsAlreadyAvailableException;
import com.twu.biblioteca.exception.BookIsNotAvailableException;
import com.twu.biblioteca.exception.EmptyBookListException;
import com.twu.biblioteca.exception.MovieIsNotAvailableException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// TODO: Refactor
public class Library {

    private List<Book> bookList;
    private List<Movie> movieList;


    public Library(List<Book> bookList) {
        this.bookList = bookList;
    }

    public Library() {
        Book[] bookList = {
                new Book("Lord ot the Rings: Fellowship of the Ring", "J.R.R. Tolkien", 1954, Availability.AVAILABLE),
                new Book("Lord ot the Rings: The Two Towers", "J.R.R. Tolkien", 1954, Availability.AVAILABLE),
                new Book("Lord ot the Rings: The Return of the King", "J.R.R. Tolkien", 1954, Availability.RESERVED),
                new Book("Bible", "God", 0)
        };
        this.bookList = Arrays.asList(bookList);

        Movie[] movieList = {
                new Movie("Gran Torino", "Clint Eastwood", 2008, Availability.AVAILABLE),
                new Movie("Django Unchained", "Quentin Tarantino", 2013, Availability.AVAILABLE),
                new Movie("Kill Bill: Volume 1", "Quentin Tarantino", 2003, Availability.RESERVED),
                new Movie("Kill Bill: Volume 2", "Quentin Tarantino", 2004, Availability.RESERVED),
                new Movie("Pulp Fiction", "Quentin Tarantino", 1994, Availability.AVAILABLE)
        };
        this.movieList = Arrays.asList(movieList);
    }

    public String showBooks(Availability availability) throws EmptyBookListException {
        if (isBookListEmpty()) {
            throw new EmptyBookListException();
        }

        StringBuilder books = new StringBuilder();
        for (Book book : getFilteredBookList(availability)) {
                books.append(book);
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



    public String showMovies(Availability availability) {
        StringBuilder movies = new StringBuilder();
        for (Movie movie : getFilteredMovieList(availability)){
            movies.append(movie);
        }
        return movies.toString();
    }

    private List<Movie> getFilteredMovieList(Availability availability) {
        List<Movie> filteredMovies = new ArrayList<>();
        for (Movie movie: movieList) {
            if (movie.getAvailability() == availability) {
                filteredMovies.add(movie);
            }
        }
        return filteredMovies;
    }

    public void checkOutMovie (Movie movie) throws MovieIsNotAvailableException {
        if (movie.getAvailability() == Availability.RESERVED) {
            throw new MovieIsNotAvailableException();
        }
        movie.setAvailability(Availability.RESERVED);
    }
}
