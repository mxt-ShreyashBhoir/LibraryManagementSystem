package com.librarymanagementsystem.domain;

import java.util.*;

public class LibraryInventory {
    private static final LibraryInventory INSTANCE = new LibraryInventory(); // Singleton pattern

    private final Map<String, Book> books = new HashMap<>();
    private final List<Bookshelf> bookshelves = new ArrayList<>();

    private LibraryInventory() {}

    public static LibraryInventory getInstance() { return INSTANCE; }

    public void addBook(Book book) { books.put(book.getIsbn(), book); }

    public void addBookshelf(Bookshelf shelf) { bookshelves.add(shelf); }

    public void removeBook(String isbn) { books.remove(isbn); }

    public Book searchByIsbn(String isbn) { return books.get(isbn); }

    public List<Book> searchByTitle(String title) {
        return books.values().stream()
                .filter(book -> book.getTitle().equalsIgnoreCase(title))
                .toList();
    }

    public List<Book> searchByAuthor(String author) {
        return books.values().stream()
                .filter(book -> book.getAuthor().equalsIgnoreCase(author))
                .toList();
    }

    public List<Book> getAvailableBooks() {
        return books.values().stream()
                .filter(Book::isAvailable)
                .toList();
    }
}
