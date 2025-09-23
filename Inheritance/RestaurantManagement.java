package Inheritance;
// Superclass Person
class Person {
    String name;
    int id;

    Person(String name, int id) {
        this.name = name;
        this.id = id;
    }

    void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("ID: " + id);
    }
}
// Worker interface
interface Worker {
    void performDuties(); // Each worker must implement this
}
// Chef subclass
class Chef extends Person implements Worker {
    String specialty;

    Chef(String name, int id, String specialty) {
        super(name, id);
        this.specialty = specialty;
    }

    @Override
    public void performDuties() {
        System.out.println(name + " is cooking delicious " + specialty + " dishes.");
    }

    void displayRole() {
        displayInfo();
        System.out.println("Role: Chef");
        System.out.println("Specialty: " + specialty);
    }
}

// Waiter subclass
class Waiter extends Person implements Worker {
    int tableNumber;

    Waiter(String name, int id, int tableNumber) {
        super(name, id);
        this.tableNumber = tableNumber;
    }

    @Override
    public void performDuties() {
        System.out.println(name + " is serving customers at table " + tableNumber + ".");
    }

    void displayRole() {
        displayInfo();
        System.out.println("Role: Waiter");
        System.out.println("Table Number: " + tableNumber);
    }
}
public class RestaurantManagement {
    public static void main(String[] args) {
        Chef chef = new Chef("Alice", 101, "Italian");
        Waiter waiter = new Waiter("Bob", 201, 5);

        Person[] staff = {chef, waiter};
        Worker[] workers = {chef, waiter};

        System.out.println("=== Restaurant Management System ===\n");

        // Display staff info
        for (Person p : staff) {
            if (p instanceof Chef) {
                ((Chef) p).displayRole();
            } else if (p instanceof Waiter) {
                ((Waiter) p).displayRole();
            }
            System.out.println("----------------------------\n");
        }

        // Perform duties
        System.out.println("=== Staff Duties ===\n");
        for (Worker w : workers) {
            w.performDuties();
        }
    }
}
