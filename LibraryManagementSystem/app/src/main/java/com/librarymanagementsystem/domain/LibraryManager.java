package com.librarymanagementsystem.domain;

import java.time.LocalDate;
import java.util.List;

public class LibraryManager {
    private final LibraryInventory inventory;
    private final RecommendationStrategy recommendationStrategy;

    public LibraryManager(LibraryInventory inventory, RecommendationStrategy recommendationStrategy) {
        this.inventory = inventory;
        this.recommendationStrategy = recommendationStrategy;
    }


    public List<Book> recommendBooksForPatron(Patron patron) {
        return recommendationStrategy.recommend(patron, inventory);
    }

    public boolean checkoutBook(Book book, Patron patron) {
        if (book.isAvailable()) {
            book.checkout(patron);
            patron.recordBorrowing(book, LocalDate.now());
            return true;
        }
        return false;
    }

    public void returnBook(Book book) {
        book.returnBook();
    }
}