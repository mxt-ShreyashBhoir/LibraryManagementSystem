import com.librarymanagementsystem.domain.*;

import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class LibraryMain {
    public static void main(String[] args) {
        LibraryInventory inventory = LibraryInventory.getInstance();
        RecommendationStrategy recommendationStrategy = new GenreBasedRecommendation();
        // Singleton usage
        LibraryManager manager = new LibraryManager(inventory, recommendationStrategy);

        // Setup bookshelves
        Bookshelf scifiShelf = new Bookshelf("SHELF-1", "Science Fiction");
        Bookshelf romanceShelf = new Bookshelf("SHELF-2", "Romance");
        Bookshelf motivationalShelf = new Bookshelf("SHELF-3", "Motivational");
        Bookshelf horrorShelf = new Bookshelf("SHELF-4", "Horror");

        // Create books
        Book dune = new Book("Dune", "Frank Herbert", "9780441172719", 1965, List.of(Genre.SCIFI));
        Book foundation = new Book("Foundation", "Isaac Asimov", "9780553293357", 1951, List.of(Genre.SCIFI));
        Book pride = new Book("Pride and Prejudice", "Jane Austen", "9780141439518", 1813, List.of(Genre.ROMANCE));
        Book persuasion = new Book("Persuasion", "Jane Austen", "9780141439686", 1817, List.of(Genre.ROMANCE));
        Book sevenHabits = new Book("7 Habits of Highly Effective People", "Stephen Covey", "9780743269513", 1989, List.of(Genre.MOTIVATIONAL, Genre.LIFESTYLE));
        Book dracula = new Book("Dracula", "Bram Stoker", "9780141439846", 1897, List.of(Genre.HORROR));

        // Add books to shelves
        scifiShelf.addBook(dune);
        scifiShelf.addBook(foundation);
        romanceShelf.addBook(pride);
        romanceShelf.addBook(persuasion);
        motivationalShelf.addBook(sevenHabits);
        horrorShelf.addBook(dracula);

        // Register bookshelves in inventory
        inventory.addBookshelf(scifiShelf);
        inventory.addBookshelf(romanceShelf);
        inventory.addBookshelf(motivationalShelf);
        inventory.addBookshelf(horrorShelf);

        // Register books in inventory
        inventory.addBook(dune);
        inventory.addBook(foundation);
        inventory.addBook(pride);
        inventory.addBook(persuasion);
        inventory.addBook(sevenHabits);
        inventory.addBook(dracula);

        // Create patrons
        Patron alice = new Patron("Alice", "P001", "F");
        Patron bob = new Patron("Bob", "P002", "M");
        Patron charlie = new Patron("Charlie", "P003", "M");
        Patron diana = new Patron("Diana", "P004", "F");

        // Alice borrows Dune
        if (manager.checkoutBook(dune, alice)) {
            System.out.println(alice.getName() + " checked out " + dune.getTitle());
        }

        // Bob subscribes to Dune (Observer pattern)
        dune.subscribe(bob);

        // Charlie tries to checkout Dune (should fail)
        if (!manager.checkoutBook(dune, charlie)) {
            System.out.println(charlie.getName() + " tried to check out " + dune.getTitle() + ", but it is currently unavailable.");
        }

        // Charlie borrows Foundation
        if (manager.checkoutBook(foundation, charlie)) {
            System.out.println(charlie.getName() + " checked out " + foundation.getTitle());
        }

        // Diana borrows Pride and Prejudice
        if (manager.checkoutBook(pride, diana)) {
            System.out.println(diana.getName() + " checked out " + pride.getTitle());
        }

        // Bob borrows Persuasion
        if (manager.checkoutBook(persuasion, bob)) {
            System.out.println(bob.getName() + " checked out " + persuasion.getTitle());
        }

        // Diana subscribes to Dracula
        dracula.subscribe(diana);

        // Alice returns Dune → Bob should get notified
        manager.returnBook(dune);

        // Bob returns Persuasion
        manager.returnBook(persuasion);

        // Add demonstration: Charlie borrows Dracula (Diana should get notified when it's returned)
        if (manager.checkoutBook(dracula, charlie)) {
            System.out.println(charlie.getName() + " checked out " + dracula.getTitle());
        }

        // Charlie returns Dracula → Diana should be notified
        manager.returnBook(dracula);

        // Recommendations for Alice based on past borrowing
        List<Book> recommendationsForAlice = manager.recommendBooksForPatron(alice);
        System.out.println("\nRecommendations for " + alice.getName() + ":");
        for (Book book : recommendationsForAlice) {
            System.out.println("- " + book.getTitle() + " by " + book.getAuthor());
        }

        // Recommendations for Bob based on past borrowing
        List<Book> recommendationsForBob = manager.recommendBooksForPatron(bob);
        System.out.println("\nRecommendations for " + bob.getName() + ":");
        for (Book book : recommendationsForBob) {
            System.out.println("- " + book.getTitle() + " by " + book.getAuthor());
        }

        // Recommendations for Charlie based on past borrowing
        List<Book> recommendationsForCharlie = manager.recommendBooksForPatron(charlie);
        System.out.println("\nRecommendations for " + charlie.getName() + ":");
        for (Book book : recommendationsForCharlie) {
            System.out.println("- " + book.getTitle() + " by " + book.getAuthor());
        }

        // Recommendations for Diana based on past borrowing
        List<Book> recommendationsForDiana = manager.recommendBooksForPatron(diana);
        System.out.println("\nRecommendations for " + diana.getName() + ":");
        for (Book book : recommendationsForDiana) {
            System.out.println("- " + book.getTitle() + " by " + book.getAuthor());
        }
    }
}