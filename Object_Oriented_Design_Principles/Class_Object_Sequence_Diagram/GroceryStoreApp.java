package Object_Oriented_Design_Principles.Class_Object_Sequence_Diagram;

import java.util.*;

// Product class
class Product {
    private String name;
    private int quantity;
    private double pricePerUnit;

    public Product(String name, int quantity, double pricePerUnit) {
        this.name = name;
        this.quantity = quantity;
        this.pricePerUnit = pricePerUnit;
    }

    public double getTotalPrice() {
        return quantity * pricePerUnit;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPricePerUnit() {
        return pricePerUnit;
    }
}

// Customer class (Composition: owns Products)
class Customer {
    private String name;
    private List<Product> products;

    public Customer(String name) {
        this.name = name;
        this.products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public List<Product> getProducts() {
        return products;
    }

    public String getName() {
        return name;
    }
}

// BillGenerator class
class BillGenerator {
    public double generateBill(Customer customer) {
        double total = 0;
        for (Product product : customer.getProducts()) {
            total += product.getTotalPrice();
        }
        return total;
    }
}

// Main class for testing
public class GroceryStoreApp {
    public static void main(String[] args) {
        Customer customer = new Customer("Alice");

        customer.addProduct(new Product("Apples", 2, 3.0)); // 2kg @ $3
        customer.addProduct(new Product("Milk", 1, 2.0));   // 1L @ $2

        BillGenerator billGenerator = new BillGenerator();
        double totalBill = billGenerator.generateBill(customer);

        System.out.println("Customer: " + customer.getName());
        for (Product p : customer.getProducts()) {
            System.out.println(p.getName() + " - Qty: " + p.getQuantity() +
                               " @ $" + p.getPricePerUnit() +
                               " = $" + p.getTotalPrice());
        }
        System.out.println("Total Bill: $" + totalBill);
    }
}
