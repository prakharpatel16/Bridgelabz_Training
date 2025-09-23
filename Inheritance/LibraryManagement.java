package Inheritance;
// Superclass Book
class Book {
    String title;
    int publicationYear;

    Book(String title, int publicationYear) {
        this.title = title;
        this.publicationYear = publicationYear;
    }

    // Method to display book info
    void displayInfo() {
        System.out.println("Book Title: " + title);
        System.out.println("Publication Year: " + publicationYear);
    }
}
// Subclass Author
class Author extends Book {
    String name;
    String bio;

    Author(String title, int publicationYear, String name, String bio) {
        super(title, publicationYear);
        this.name = name;
        this.bio = bio;
    }

    @Override
    void displayInfo() {
        super.displayInfo(); // Display book details
        System.out.println("Author Name: " + name);
        System.out.println("Biography: " + bio);
    }
}
public class LibraryManagement {
    public static void main(String[] args) {
        // Create author-book objects
        Author book1 = new Author("The Alchemist", 1988, "Paulo Coelho", "Brazilian novelist known for inspiring works.");
        Author book2 = new Author("1984", 1949, "George Orwell", "English novelist, essayist, journalist, and critic.");

        // Store in an array
        Author[] library = {book1, book2};

        System.out.println("=== Library Management System ===\n");

        for (Author b : library) {
            b.displayInfo();
            System.out.println("------------------------------\n");
        }
    }
}
