package Inheritance;
// Base class Order
class Order {
    String orderId;
    String orderDate;

    Order(String orderId, String orderDate) {
        this.orderId = orderId;
        this.orderDate = orderDate;
    }

    // Method to get order status
    String getOrderStatus() {
        return "Order Placed";
    }

    void displayInfo() {
        System.out.println("Order ID: " + orderId);
        System.out.println("Order Date: " + orderDate);
        System.out.println("Status: " + getOrderStatus());
    }
}
// Subclass ShippedOrder
class ShippedOrder extends Order {
    String trackingNumber;

    ShippedOrder(String orderId, String orderDate, String trackingNumber) {
        super(orderId, orderDate);
        this.trackingNumber = trackingNumber;
    }

    @Override
    String getOrderStatus() {
        return "Order Shipped";
    }

    @Override
    void displayInfo() {
        super.displayInfo();
        System.out.println("Tracking Number: " + trackingNumber);
    }
}

// Subclass DeliveredOrder
class DeliveredOrder extends ShippedOrder {
    String deliveryDate;

    DeliveredOrder(String orderId, String orderDate, String trackingNumber, String deliveryDate) {
        super(orderId, orderDate, trackingNumber);
        this.deliveryDate = deliveryDate;
    }

    @Override
    String getOrderStatus() {
        return "Order Delivered";
    }

    @Override
    void displayInfo() {
        super.displayInfo();
        System.out.println("Delivery Date: " + deliveryDate);
    }
}
public class RetailOrder {
    public static void main(String[] args) {
        // Create orders
        Order order1 = new Order("O1001", "2025-09-13");
        ShippedOrder order2 = new ShippedOrder("O1002", "2025-09-12", "TRK12345");
        DeliveredOrder order3 = new DeliveredOrder("O1003", "2025-09-10", "TRK67890", "2025-09-13");

        Order[] orders = {order1, order2, order3};

        System.out.println("=== Online Retail Order Management ===\n");

        for (Order o : orders) {
            o.displayInfo();
            System.out.println("------------------------------\n");
        }
    }
}
