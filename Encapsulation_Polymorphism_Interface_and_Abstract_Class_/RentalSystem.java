package PolymorphismAbstractionInterface_Problems;
interface Insurable {
    double calculateInsurance();
    void getInsuranceDetails();
}

abstract class Vehicle {
    private String vehicleNumber;
    private String type;
    private double rentalRate;

    public Vehicle(String vehicleNumber, String type, double rentalRate) {
        this.vehicleNumber = vehicleNumber;
        this.type = type;
        this.rentalRate = rentalRate;
    }

    public double getRentalRate() { return rentalRate; }

    public abstract double calculateRentalCost(int days);
}

// Subclasses
class Car extends Vehicle implements Insurable {
    public Car(String num, double rate) { super(num, "Car", rate); }

    @Override
    public double calculateRentalCost(int days) { return days * getRentalRate(); }

    @Override
    public double calculateInsurance() { return getRentalRate() * 0.15; }

    @Override
    public void getInsuranceDetails() { System.out.println("Car Insurance: 15% of rate"); }
}

class Bike extends Vehicle implements Insurable {
    public Bike(String num, double rate) { super(num, "Bike", rate); }

    @Override
    public double calculateRentalCost(int days) { return days * getRentalRate(); }

    @Override
    public double calculateInsurance() { return getRentalRate() * 0.05; }

    @Override
    public void getInsuranceDetails() { System.out.println("Bike Insurance: 5% of rate"); }
}

class Truck extends Vehicle implements Insurable {
    public Truck(String num, double rate) { super(num, "Truck", rate); }

    @Override
    public double calculateRentalCost(int days) { return days * getRentalRate() * 1.5; }

    @Override
    public double calculateInsurance() { return getRentalRate() * 0.25; }

    @Override
    public void getInsuranceDetails() { System.out.println("Truck Insurance: 25% of rate"); }
}
public class RentalSystem {
    public static void main(String[] args) {
        Vehicle[] vehicles = {
            new Car("CAR123", 1000),
            new Bike("BIKE456", 500),
            new Truck("TRUCK789", 2000)
        };

        for (Vehicle v : vehicles) {
            System.out.println("Rental Cost (3 days): " + v.calculateRentalCost(3));
            if (v instanceof Insurable) {
                Insurable i = (Insurable) v;
                System.out.println("Insurance: " + i.calculateInsurance());
            }
            System.out.println(" ");
        }
    }
}

