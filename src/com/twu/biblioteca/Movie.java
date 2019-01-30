package com.twu.biblioteca;

import com.twu.biblioteca.exception.RatingIsNotValidException;

public class Movie {

    private String name;
    private String director;
    private int year;
    private int rating;
    private boolean rated;

    public Movie(String name, String director, int year) {
        this.name = name;
        this.director = director;
        this.year = year;
    }

    public void setRating(int rating) throws RatingIsNotValidException {
        if (rating == 0) {
            this.rated = false;
        } else if (rating < 1 || rating > 10) {
            throw new RatingIsNotValidException();
        }else {
            this.rating = rating;
            this.rated = true;
        }
    }

    public int getRating() {
        return rating;
    }

    public boolean isRated() {
        return rated;
    }
}
