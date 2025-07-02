package com.librarymanagementsystem.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Patron {
    private final String name;
    private final String patronId;
    private final String gender;
    private final Map<Book, List<LocalDate>> borrowingHistory = new HashMap<>();

    public Patron(String name, String patronId, String gender) {
        this.name = name;
        this.patronId = patronId;
        this.gender = gender;
    }

    public void recordBorrowing(Book book, LocalDate date) {
        borrowingHistory.computeIfAbsent(book, k -> new ArrayList<>()).add(date);
    }

    public Map<Book, List<LocalDate>> getBorrowingHistory() {
        return borrowingHistory;
    }

    public String getName() { return name; }

    public void notifyAvailable(Book book) {
        System.out.println("Notification for " + name + ": Book '" + book.getTitle() + "' is now available!");
    }
}
