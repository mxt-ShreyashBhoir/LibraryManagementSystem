package com.librarymanagementsystem.domain;

import java.time.LocalDate;
import java.util.Date;

public class Lending {
    public static boolean checkout(Book book, Patron patron) {
        if (book.isAvailable()) {
            book.checkout(patron);
            patron.recordBorrowing(book, LocalDate.now());
            return true;
        }
        return false;
    }

    public static void returnBook(Book book) {
        book.returnBook();
    }
}