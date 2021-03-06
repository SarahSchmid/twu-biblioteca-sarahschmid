package com.twu.biblioteca;

import com.twu.biblioteca.exception.BookIsAlreadyAvailableException;
import com.twu.biblioteca.exception.BookIsNotAvailableException;
import com.twu.biblioteca.exception.EmptyBookListException;
import com.twu.biblioteca.exception.MovieIsNotAvailableException;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

public class LibraryTest {

    @Test (expected = EmptyBookListException.class)
    public void showBooks_should_throw_EmptyBookListException_when_there_is_no_book_in_the_library() throws Exception {
        List<Book> bookList = new ArrayList<>();
        Library library = new Library(bookList);
        library.showBooks(Availability.AVAILABLE);
    }

    @Test
    public void showBooks_should_return_one_book_when_only_one_book_is_available() throws Exception {
        List<Book> bookList = new ArrayList<>();
        bookList.add(new Book("Moby Dick", "Herman Melville", 1851, Availability.AVAILABLE));
        Library library = new Library(bookList);
        String result = library.showBooks(Availability.AVAILABLE);

        assertEquals("|Moby Dick                                         |Herman Melville     |1851|\n", result);
    }


    @Test
    public void showBooks_should_return_multiple_books_when_more_than_one_book_is_available() throws Exception {
        List<Book> bookList = new ArrayList<>();
        bookList.add(new Book("Moby Dick", "Herman Melville", 1851, Availability.AVAILABLE));
        bookList.add(new Book("Harry Potter", "J.K. Rowling", 1997, Availability.AVAILABLE));
        bookList.add(new Book("Lord of the Ring", "J.R.R. Tolkien", 1954, Availability.AVAILABLE));

        Library library = new Library(bookList);
        String result = library.showBooks(Availability.AVAILABLE);

        String expected =
                "|Moby Dick                                         |Herman Melville     |1851|\n" +
                "|Harry Potter                                      |J.K. Rowling        |1997|\n" +
                "|Lord of the Ring                                  |J.R.R. Tolkien      |1954|\n";

        assertEquals(expected, result);
    }

    @Test
    public void showBooks_should_only_return_the_books_that_are_available_for_checkout() throws Exception {
        List<Book> bookList = new ArrayList<>();
        bookList.add(new Book("Moby Dick", "Herman Melville", 1851, Availability.AVAILABLE));
        bookList.add(new Book("Harry Potter", "J.K. Rowling", 1997, Availability.AVAILABLE));
        bookList.add(new Book("Lord of the Ring", "J.R.R. Tolkien", 1954, Availability.RESERVED));

        Library library = new Library(bookList);
        String result = library.showBooks(Availability.AVAILABLE);

        String expected =
                        "|Moby Dick                                         |Herman Melville     |1851|\n" +
                        "|Harry Potter                                      |J.K. Rowling        |1997|\n";

        assertEquals(expected, result);
    }

    @Test
    public void showBooks_should_only_return_the_books_that_are_already_reserved() throws EmptyBookListException {
        List<Book> bookList = new ArrayList<>();
        bookList.add(new Book("Moby Dick", "Herman Melville", 1851, Availability.AVAILABLE));
        bookList.add(new Book("Harry Potter", "J.K. Rowling", 1997, Availability.RESERVED));
        bookList.add(new Book("Lord of the Ring", "J.R.R. Tolkien", 1954, Availability.RESERVED));

        Library library = new Library(bookList);
        String result = library.showBooks(Availability.RESERVED);

        String expected =
                        "|Harry Potter                                      |J.K. Rowling        |1997|\n" +
                        "|Lord of the Ring                                  |J.R.R. Tolkien      |1954|\n";

        assertEquals(expected, result);
    }

    @Test
    public void checkoutBook_should_set_the_availability_of_the_chosen_book_to_reserved() throws Exception {
        Book book = new Book("Moby Dick", "Herman Melville", 1851);

        List<Book> bookList = new ArrayList<>();
        bookList.add(book);

        Library library = new Library(bookList);
        library.checkoutBook(book);

        assertSame(book.getAvailability(), Availability.RESERVED);
    }

    @Test (expected = BookIsNotAvailableException.class)
    public void checkoutBook_should_throw_BookIsNotAvailableException_if_its_already_reserved() throws Exception {
        Book book = new Book("Moby Dick", "Herman Melville", 1851, Availability.RESERVED);

        List<Book> bookList = new ArrayList<>();
        bookList.add(book);
        Library library = new Library(bookList);

        library.checkoutBook(book);
    }

    @Test (expected = BookIsAlreadyAvailableException.class)
    public void checkInBook_should_throw_BookIsAlreadyAvailableException_if_the_book_cannot_be_returned() throws BookIsAlreadyAvailableException {
        Book book = new Book("Moby Dick", "Herman Melville", 1851, Availability.AVAILABLE);

        List<Book> bookList = new ArrayList<>();
        bookList.add(book);
        Library library = new Library(bookList);

        library.checkInBook(book);
    }

    @Test
    public void checkInBook_should_set_the_availability_of_the_chosen_book_to_available() throws BookIsAlreadyAvailableException {
        Book book = new Book("Moby Dick", "Herman Melville", 1851, Availability.RESERVED);

        List<Book> bookList = new ArrayList<>();
        bookList.add(book);

        Library library = new Library(bookList);
        library.checkInBook(book);

        assertSame(book.getAvailability(), Availability.AVAILABLE);
    }

    @Test
    public void getFilteredBooklist_should_return_a_booklist_with_all_available_books() {
        List<Book> bookList = new ArrayList<>();
        Book book = new Book("Moby Dick", "Herman Melville", 1851, Availability.AVAILABLE);
        bookList.add(book);
        bookList.add(new Book("Harry Potter", "J.K. Rowling", 1997, Availability.AVAILABLE));
        bookList.add(new Book("Lord of the Ring", "J.R.R. Tolkien", 1954, Availability.RESERVED));
        Library library = new Library(bookList);

        List<Book> expected = new ArrayList<>();
        expected.add(book);
        expected.add(new Book("Harry Potter", "J.K. Rowling", 1997, Availability.AVAILABLE));

        List<Book> result = library.getFilteredBookList(Availability.AVAILABLE);

        assertEquals(expected.get(0).getAvailability(), result.get(0).getAvailability());
        assertEquals(expected.get(0).toString(), result.get(0).toString());

        assertEquals(expected.get(1).getAvailability(), result.get(1).getAvailability());
        assertEquals(expected.get(1).toString(), result.get(1).toString());
    }

    @Test
    public void getFilteredMovieList_should_return_a_list_with_all_available_movies() {
        Library library = new Library();
        List<Movie> expected = new ArrayList<>();
        expected.add(new Movie("Gran Torino", "Clint Eastwood", 2008, Availability.AVAILABLE));
        expected.add(new Movie("Django Unchained", "Quentin Tarantino", 2013, Availability.AVAILABLE));
        expected.add(new Movie("Pulp Fiction", "Quentin Tarantino", 1994, Availability.AVAILABLE));

        List<Movie> result = library.getFilteredMovieList(Availability.AVAILABLE);

        assertEquals(expected.get(0).getTitle(), result.get(0).getTitle());
        assertEquals(expected.get(0).getAvailability(), result.get(0).getAvailability());

        assertEquals(expected.get(1).getTitle(), result.get(1).getTitle());
        assertEquals(expected.get(1).getAvailability(), result.get(1).getAvailability());

        assertEquals(expected.get(2).getTitle(), result.get(2).getTitle());
        assertEquals(expected.get(2).getAvailability(), result.get(2).getAvailability());
    }

    @Test
    public void showMovies_should_return_all_movies_that_are_available() {
        Library library = new Library();
        String expected =
                "|Gran Torino                                       |Clint Eastwood      |2008|0 \n" +
                "|Django Unchained                                  |Quentin Tarantino   |2013|0 \n" +
                "|Pulp Fiction                                      |Quentin Tarantino   |1994|0 \n";

        String result = library.showMovies(Availability.AVAILABLE);

        assertEquals(expected, result);
    }

    @Test (expected = MovieIsNotAvailableException.class)
    public void checkOutMovie_should_throw_a_MovieIsNotAvailableException_when_the_movie_is_already_reserved() throws Exception {
        Library library = new Library();
        Movie movie = new Movie("Gran Torino", "Clint Eastwood", 2008, Availability.RESERVED);

        library.checkOutMovie(movie);
    }

    @Test
    public void checkOutMovie_should_set_the_availability_of_the_given_movie_to_reserved() throws Exception {
        Library library = new Library();
        Movie movie = new Movie("Gran Torino", "Clint Eastwood", 2008, Availability.AVAILABLE);

        library.checkOutMovie(movie);

        assertEquals(Availability.RESERVED, movie.getAvailability());
    }
}