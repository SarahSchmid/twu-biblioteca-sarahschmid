package com.twu.biblioteca;

import com.twu.biblioteca.exception.RatingIsNotValidException;
import org.junit.Test;

import static org.junit.Assert.assertSame;

public class MovieTest {

    @Test (expected = RatingIsNotValidException.class)
    public void setRating_should_throw_a_RatingIsNotValidException_when_the_rating_is_not_between_1_and_10() throws Exception {
        Movie movie = new Movie("Frozen", "Disney", 2016, Availability.AVAILABLE);
        movie.setRating(15);
    }

    @Test
    public void setRating_should_be_unrated_when_the_rating_is_0() throws Exception {
        Movie movie = new Movie("Frozen", "Disney", 2016, Availability.AVAILABLE);
        movie.setRating(0);

        assertSame(false, movie.isRated());

    }

    @Test
    public void setRating_should_set_the_rating_value_and_mark_it_as_rated() throws Exception {
        Movie movie = new Movie("Frozen", "Disney", 2016, Availability.AVAILABLE);
        movie.setRating(7);

        assertSame(true, movie.isRated());
        assertSame(7, movie.getRating());
    }
}