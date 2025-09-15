public class Vehicle {
    // ---------- STATIC ----------
    private static double registrationFee = 100.0; // Default registration fee

    // ---------- INSTANCE VARIABLES ----------
    private final String registrationNumber; // Immutable unique identifier
    private String ownerName;
    private String vehicleType;

    // ---------- CONSTRUCTOR (using 'this') ----------
    public Vehicle(String ownerName, String vehicleType, String registrationNumber) {
        this.ownerName = ownerName;
        this.vehicleType = vehicleType;
        this.registrationNumber = registrationNumber; // final → assigned once only
    }

    // ---------- STATIC METHOD ----------
    public static void updateRegistrationFee(double newFee) {
        if (newFee >= 0.0) {
            registrationFee = newFee;
        } else {
            System.err.println("❌ Invalid registration fee. Must be non-negative.");
        }
    }

    // ---------- INSTANCE METHOD ----------
    public void displayRegistrationDetails() {
        // Using 'instanceof' to verify object type
        if (this instanceof Vehicle) {
            System.out.println("Owner Name: " + ownerName);
            System.out.println("Vehicle Type: " + vehicleType);
            System.out.println("Registration Number: " + registrationNumber);
            System.out.println("Registration Fee: $" + registrationFee);
        } else {
            System.err.println("❌ The object is not an instance of Vehicle.");
        }
    }

    // ---------- GETTERS ----------
    public String getOwnerName() {
        return ownerName;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    // ---------- MAIN ----------
    public static void main(String[] args) {
        // Update registration fee (affects all vehicles)
        Vehicle.updateRegistrationFee(150.0);

        // Create new vehicle objects
        Vehicle vehicle1 = new Vehicle("Honest Raj", "Sedan", "ABC123");
        Vehicle vehicle2 = new Vehicle("Prince Danish", "SUV", "XYZ789");

        // Display details
        vehicle1.displayRegistrationDetails();
        System.out.println();
        vehicle2.displayRegistrationDetails();
    }
}
