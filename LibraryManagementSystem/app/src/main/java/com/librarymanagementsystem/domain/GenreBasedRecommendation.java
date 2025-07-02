package com.librarymanagementsystem.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GenreBasedRecommendation implements RecommendationStrategy {
    @Override
    public List<Book> recommend(Patron patron, LibraryInventory inventory) {
        Set<Genre> preferredGenres = new HashSet<>();
        for (Book borrowedBook : patron.getBorrowingHistory().keySet()) {
            preferredGenres.addAll(borrowedBook.getGenres());
        }
        return inventory.getAvailableBooks().stream()
                .filter(book -> book.getGenres().stream().anyMatch(preferredGenres::contains))
                .toList();
    }
}
