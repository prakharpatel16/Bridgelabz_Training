// Book class
class Book {
    // ---------- STATIC ----------
    private static String libraryName; // shared across all books

    // ---------- INSTANCE VARIABLES ----------
    private String title;
    private String author;

    // ---------- FINAL ----------
    private final String isbn; // unique, cannot be changed after initialization

    // ---------- CONSTRUCTOR (using 'this') ----------
    public Book(String title, String author, String isbn) {
        this.title = title;   // resolve ambiguity using this
        this.author = author;
        this.isbn = isbn;     // final variable assigned only once
    }

    // ---------- STATIC METHODS ----------
    public static void setLibraryName(String name) {
        libraryName = name;
    }

    public static void displayLibraryName() {
        System.out.println("Library Name: " + libraryName);
    }

    // ---------- DISPLAY WITH INSTANCEOF ----------
    public void displayBookDetails() {
        if (this instanceof Book) { // safe type check
            System.out.println("Title: " + title);
            System.out.println("Author: " + author);
            System.out.println("ISBN: " + isbn);
        } else {
            System.err.println("Invalid object - not a Book instance.");
        }
    }

    // ---------- GETTERS ----------
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getIsbn() {
        return isbn;
    }
}

// Library management main class
public class Library {
    public static void main(String[] args) {
        // Static variable set once for all books
        Book.setLibraryName("Egmore Library");

        // Display library name
        Book.displayLibraryName();

        // Create book object
        Book book1 = new Book("Effective Java", "Joshua Bloch", "978-0134685991");

        // Display book details
        book1.displayBookDetails();
    }
}
