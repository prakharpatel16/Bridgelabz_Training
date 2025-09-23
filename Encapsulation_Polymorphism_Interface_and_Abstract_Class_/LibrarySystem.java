package PolymorphismAbstractionInterface_Problems;
interface Reservable {
 void reserveItem();
 boolean checkAvailability();
}
abstract class LibraryItem {
 private String itemId;
 private String title;
 private String author;

 public LibraryItem(String itemId, String title, String author) {
     this.itemId = itemId;
     this.title = title;
     this.author = author;
 }

 public void getItemDetails() {
     System.out.println("ID: " + itemId + ", Title: " + title + ", Author: " + author);
 }

 public abstract int getLoanDuration();
}
class Book extends LibraryItem implements Reservable {
 private boolean available = true;

 public Book(String id, String title, String author) {
     super(id, title, author);
 }

 @Override
 public int getLoanDuration() { return 14; }

 @Override
 public void reserveItem() { available = false; }

 @Override
 public boolean checkAvailability() { return available; }
}

class Magazine extends LibraryItem implements Reservable {
 private boolean available = true;

 public Magazine(String id, String title, String author) {
     super(id, title, author);
 }

 @Override
 public int getLoanDuration() { return 7; }

 @Override
 public void reserveItem() { available = false; }

 @Override
 public boolean checkAvailability() { return available; }
}

class DVD extends LibraryItem implements Reservable {
 private boolean available = true;

 public DVD(String id, String title, String author) {
     super(id, title, author);
 }

 @Override
 public int getLoanDuration() { return 3; }

 @Override
 public void reserveItem() { available = false; }

 @Override
 public boolean checkAvailability() { return available; }
}
public class LibrarySystem {
 public static void main(String[] args) {
     LibraryItem[] items = {
         new Book("B001", "Java Programming", "James Gosling"),
         new Magazine("M002", "Tech Monthly", "Editor A"),
         new DVD("D003", "Inception", "Nolan")
     };

     for (LibraryItem item : items) {
         item.getItemDetails();
         System.out.println("Loan Duration: " + item.getLoanDuration() + " days");
         if (item instanceof Reservable) {
             Reservable r = (Reservable) item;
             System.out.println("Available: " + r.checkAvailability());
         }
         System.out.println(" ");
     }
 }
}

