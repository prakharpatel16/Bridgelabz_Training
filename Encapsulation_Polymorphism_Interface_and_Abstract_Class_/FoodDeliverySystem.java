package PolymorphismAbstractionInterface_Problems;
interface Discountable {
 double applyDiscount(double total);
 void getDiscountDetails();
}
abstract class FoodItem {
 private String itemName;
 private double price;
 private int quantity;

 public FoodItem(String itemName, double price, int quantity) {
     this.itemName = itemName;
     this.price = price;
     this.quantity = quantity;
 }

 public double getPrice() { return price; }
 public int getQuantity() { return quantity; }
 public String getItemName() { return itemName; }

 public void getItemDetails() {
     System.out.println("Item: " + itemName + ", Price: " + price + ", Qty: " + quantity);
 }

 public abstract double calculateTotalPrice();
}
class VegItem extends FoodItem implements Discountable {
 public VegItem(String name, double price, int qty) {
     super(name, price, qty);
 }

 @Override
 public double calculateTotalPrice() {
     return getPrice() * getQuantity();
 }

 @Override
 public double applyDiscount(double total) {
     return total * 0.90; 
 }

 @Override
 public void getDiscountDetails() {
     System.out.println("Veg Discount: 10%");
 }
}

class NonVegItem extends FoodItem implements Discountable {
 public NonVegItem(String name, double price, int qty) {
     super(name, price, qty);
 }

 @Override
 public double calculateTotalPrice() {
     return getPrice() * getQuantity() + 50;
 }

 @Override
 public double applyDiscount(double total) {
     return total * 0.95; 
 }

 @Override
 public void getDiscountDetails() {
     System.out.println("Non-Veg Discount: 5%");
 }
}
public class FoodDeliverySystem {
 public static void main(String[] args) {
     FoodItem[] items = {
         new VegItem("Paneer Tikka", 200, 2),
         new NonVegItem("Sahi Paneer", 300, 1)
     };

     for (FoodItem item : items) {
         item.getItemDetails();
         double total = item.calculateTotalPrice();
         if (item instanceof Discountable) {
             total = ((Discountable) item).applyDiscount(total);
         }
         System.out.println("Final Price: " + total);
         System.out.println(" ");
     }
 }
}

