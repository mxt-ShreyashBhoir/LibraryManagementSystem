package com.librarymanagementsystem.domain;

import java.util.ArrayList;
import java.util.List;

public class Book {
    private final String title;
    private final String author;
    private final String isbn;
    private final int publicationYear;
    private final List<Genre> genres;
    private Patron activePatron; // null if available
    private final List<Patron> subscribers = new ArrayList<>(); // Observer pattern

    public Book(String title, String author, String isbn, int publicationYear, List<Genre> genres) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.publicationYear = publicationYear;
        this.genres = genres;
    }

    public boolean isAvailable() {
        return activePatron == null;
    }

    public void checkout(Patron patron) {
        this.activePatron = patron;
    }

    public void returnBook() {
        this.activePatron = null;
        notifySubscribers();
    }

    public void subscribe(Patron patron) {
        if (!subscribers.contains(patron)) {
            subscribers.add(patron);
        }
    }

    private void notifySubscribers() {
        for (Patron subscriber : subscribers) {
            subscriber.notifyAvailable(this);
        }
        subscribers.clear();
    }

    // Getters
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getIsbn() {
        return isbn;
    }

    public List<Genre> getGenres() {
        return genres;
    }

    public Patron getActivePatron() {
        return activePatron;
    }
}

