package com.librarymanagementsystem.domain;

import java.util.List;

public interface RecommendationStrategy {
    List<Book> recommend(Patron patron, LibraryInventory inventory);
}
