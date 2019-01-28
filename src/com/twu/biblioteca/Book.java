package com.twu.biblioteca;

public class Book {

    private String title;
    private String author;
    private int year;

    public enum Availability {
        AVAILABLE,
        RESERVED
    }
    private Availability availability;

    public Book(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.availability = Availability.AVAILABLE;
    }

    public Book(String title, String author, int year, Availability availability) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.availability = availability;
    }

    public Availability getAvailability() {
        return availability;
    }

    public void setAvailability(Availability availability) {
        this.availability = availability;
    }

    @Override
    public String toString() {
        return String.format("|%-50s|%-20s|%-4s|%n", title, author, year);
    }
}
