package Inheritance;
// Superclass Vehicle
class Vehicle {
    String model;
    int maxSpeed;

    Vehicle(String model, int maxSpeed) {
        this.model = model;
        this.maxSpeed = maxSpeed;
    }

    void displayInfo() {
        System.out.println("Model: " + model);
        System.out.println("Max Speed: " + maxSpeed + " km/h");
    }
}
// Refuelable interface
interface Refuelable {
    void refuel();
}
// ElectricVehicle subclass
class ElectricVehicle extends Vehicle {
    int batteryCapacity; // in kWh

    ElectricVehicle(String model, int maxSpeed, int batteryCapacity) {
        super(model, maxSpeed);
        this.batteryCapacity = batteryCapacity;
    }

    void charge() {
        System.out.println(model + " is charging. Battery capacity: " + batteryCapacity + " kWh.");
    }

    @Override
    void displayInfo() {
        super.displayInfo();
        System.out.println("Battery Capacity: " + batteryCapacity + " kWh");
        System.out.println("Vehicle Type: Electric Vehicle");
    }
}

// PetrolVehicle subclass implementing Refuelable
class PetrolVehicle extends Vehicle implements Refuelable {
    double fuelTankCapacity; // in liters

    PetrolVehicle(String model, int maxSpeed, double fuelTankCapacity) {
        super(model, maxSpeed);
        this.fuelTankCapacity = fuelTankCapacity;
    }

    @Override
    public void refuel() {
        System.out.println(model + " is refueling. Tank capacity: " + fuelTankCapacity + " liters.");
    }

    @Override
    void displayInfo() {
        super.displayInfo();
        System.out.println("Fuel Tank Capacity: " + fuelTankCapacity + " liters");
        System.out.println("Vehicle Type: Petrol Vehicle");
    }
}
public class VehicleManagement {
    public static void main(String[] args) {
        ElectricVehicle ev = new ElectricVehicle("Tesla Model 3", 250, 75);
        PetrolVehicle pv = new PetrolVehicle("Toyota Corolla", 180, 50);

        Vehicle[] vehicles = {ev, pv};
        Refuelable[] refuelables = {pv}; // only petrol vehicles

        System.out.println("=== Vehicle Management System ===\n");

        // Display vehicle info
        for (Vehicle v : vehicles) {
            v.displayInfo();
            System.out.println("--------------------------\n");
        }

        // Refuel petrol vehicles
        System.out.println("=== Refueling Petrol Vehicles ===\n");
        for (Refuelable r : refuelables) {
            r.refuel();
        }

        // Charge electric vehicles
        System.out.println("\n=== Charging Electric Vehicles ===\n");
        ev.charge();
    }
}
