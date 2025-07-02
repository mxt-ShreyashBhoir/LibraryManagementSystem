📚 Library Management System
A Java-based Library Management System demonstrating Object-Oriented Programming (OOP), SOLID principles, and key design patterns (Observer, Strategy). This project simulates a library's core functionalities such as book and patron management, lending processes, and includes advanced features like recommendations and notifications.

UML Diagram

![image](https://github.com/user-attachments/assets/8f1295bf-fdf4-4a3b-8e2c-2b9e5fc52b0e)


🚀 Features
✅ Book Management

Add, remove, update books in the library.

Search books by title, author, or ISBN.

✅ Patron Management

Add patrons.

Track patron borrowing history.

✅ Lending System

Check out and return books.

Maintain inventory of available and borrowed books.

✅ Observer Pattern (Notifications)

Patrons can subscribe to books and get notified when they become available.

✅ Strategy Pattern (Recommendations)

Genre-based book recommendations generated for patrons based on their borrowing history.

✅ Bookshelf System

Organize books into categorized bookshelves.

✅ Loose Coupling & SOLID Principles

Classes are well-separated with clear responsibilities, making them easy to maintain, extend, or test.


✅ LibraryManager: Orchestrates lending, recommendations, and inventory operations.

Patron: Represents library members.

Book: Represents books with observer functionality for notifications.

RecommendationStrategy: Interface for recommendation algorithms (implemented by GenreBasedRecommendation).

🔑 Technologies
Java 21

Collections API (Map, List)

Java OOP features (Encapsulation, Inheritance, Polymorphism, Abstraction)

No persistence layer — designed for in-memory simulation.

🛠️ How to Run
Clone the repository:

bash
Copy
Edit
git clone https://github.com/yourusername/library-management-system.git
cd library-management-system
Compile:

bash
Copy
Edit
./gradlew build
Run:

bash
Copy
Edit
./gradlew run
Or directly from your IDE by running the LibraryMain class.

📖 Example Usage
Create bookshelves, add books to them, and register books in the library.

Patrons check out books, subscribe for notifications, and receive recommendations.

Observer pattern demonstrates notifications when subscribed books become available.

Strategy pattern demonstrates flexible recommendation logic.
