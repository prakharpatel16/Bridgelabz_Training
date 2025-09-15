public class Product {
    // ---------- STATIC ----------
    private static double discount = 0.0; // shared discount across all products

    // ---------- INSTANCE VARIABLES ----------
    private final String productID; // unique & immutable
    private String productName;
    private double price;
    private int quantity;

    // ---------- CONSTRUCTOR (using 'this') ----------
    public Product(String productID, String productName, double price, int quantity) {
        this.productID = productID;     // final → assigned only once
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
    }

    // ---------- STATIC METHOD ----------
    public static void updateDiscount(double newDiscount) {
        if (newDiscount >= 0.0 && newDiscount <= 100.0) {
            discount = newDiscount;
        } else {
            System.err.println("❌ Invalid discount percentage. Must be between 0 and 100.");
        }
    }

    // ---------- CALCULATION ----------
    public double getDiscountedPrice() {
        return price - (price * discount / 100);
    }

    // ---------- INSTANCEOF + DISPLAY ----------
    public void displayProductDetails() {
        if (this instanceof Product) { // safe type check
            System.out.println("Product ID: " + productID);
            System.out.println("Product Name: " + productName);
            System.out.println("Price: $" + price);
            System.out.println("Quantity: " + quantity);
            System.out.println("Discount: " + discount + "%");
            System.out.println("Price after Discount: $" + getDiscountedPrice());
        } else {
            System.err.println("❌ The object is not an instance of Product.");
        }
    }

    // ---------- GETTERS & SETTERS ----------
    public String getProductID() {
        return productID;
    }
    public String getProductName() {
        return productName;
    }
    public void setProductName(String productName) {
        this.productName = productName;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    // ---------- MAIN ----------
    public static void main(String[] args) {
        // Apply global discount (shared)
        Product.updateDiscount(10.0); // 10% discount

        // Create products
        Product product1 = new Product("P001", "Laptop", 1200.00, 5);
        Product product2 = new Product("P002", "Smartphone", 800.00, 10);

        // Display details
        product1.displayProductDetails();
        System.out.println();
        product2.displayProductDetails();
    }
}
