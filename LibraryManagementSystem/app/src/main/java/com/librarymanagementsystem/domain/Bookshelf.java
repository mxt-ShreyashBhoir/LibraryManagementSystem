package com.librarymanagementsystem.domain;

import java.util.*;

public class Bookshelf {
    private final String shelfId;
    private final String name;
    private final List<Book> books = new ArrayList<>();

    public Bookshelf(String shelfId, String name) {
        this.shelfId = shelfId;
        this.name = name;
    }

    public void addBook(Book book) { books.add(book); }

    public boolean removeBook(Book book) { return books.remove(book); }

    public List<Book> getBooks() { return Collections.unmodifiableList(books); }

    public String getName() { return name; }
    public String getShelfId() { return shelfId; }
}
