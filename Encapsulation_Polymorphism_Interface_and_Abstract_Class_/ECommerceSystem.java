package PolymorphismAbstractionInterface_Problems;
interface Taxable {
    double calculateTax();
    void getTaxDetails();
}

abstract class Product {
    private String productId;
    private String name;
    private double price;

    public Product(String productId, String name, double price) {
        this.productId = productId;
        this.name = name;
        this.price = price;
    }

    public double getPrice() { return price; }
    public String getName() { return name; }

    public abstract double calculateDiscount();
}
class Electronics extends Product implements Taxable {
    public Electronics(String id, String name, double price) {
        super(id, name, price);
    }

    @Override
    public double calculateDiscount() { return getPrice() * 0.10; }

    @Override
    public double calculateTax() { return getPrice() * 0.18; }

    @Override
    public void getTaxDetails() { System.out.println("Electronics Tax: 18%"); }
}

class Clothing extends Product implements Taxable {
    public Clothing(String id, String name, double price) {
        super(id, name, price);
    }

    @Override
    public double calculateDiscount() { return getPrice() * 0.20; }

    @Override
    public double calculateTax() { return getPrice() * 0.05; }

    @Override
    public void getTaxDetails() { System.out.println("Clothing Tax: 5%"); }
}

class Groceries extends Product {
    public Groceries(String id, String name, double price) {
        super(id, name, price);
    }

    @Override
    public double calculateDiscount() { return getPrice() * 0.05; }
}
public class ECommerceSystem {
    public static void main(String[] args) {
        Product[] products = {
            new Electronics("E101", "Laptop", 60000),
            new Clothing("C201", "Jacket", 3000),
            new Groceries("G301", "Apples", 200)
        };
        for (Product p : products) {
            double discount = p.calculateDiscount();
            double tax = (p instanceof Taxable) ? ((Taxable) p).calculateTax() : 0;
            double finalPrice = p.getPrice() + tax - discount;
            System.out.println(p.getName() + " Final Price: " + finalPrice);
        }
    }
}

