package com.twu.biblioteca;

import com.twu.biblioteca.exception.RatingIsNotValidException;

public class Movie {

    private String title;
    private String director;
    private int year;
    private int rating;
    private boolean rated;
    private Availability availability;

    public Movie(String title, String director, int year, Availability availability) {
        this.title = title;
        this.director = director;
        this.year = year;
        this.availability = availability;
        this.rating = 0;
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

    public String getTitle() {
        return title;
    }

    public Availability getAvailability() {
        return availability;
    }

    public int getRating() {
        return rating;
    }

    public boolean isRated() {
        return rated;
    }

    @Override
    public String toString() {
        return String.format("|%-50s|%-20s|%-4s|%-2s%n", title, director, year, rating);
    }
}
