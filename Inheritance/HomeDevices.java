package Inheritance;
// Superclass Device
class Device {
    String deviceId;
    String status; // e.g., "ON" or "OFF"

    Device(String deviceId, String status) {
        this.deviceId = deviceId;
        this.status = status;
    }

    // Method to display device status
    void displayStatus() {
        System.out.println("Device ID: " + deviceId);
        System.out.println("Status: " + status);
    }
}
// Subclass Thermostat
class Thermostat extends Device {
    double temperatureSetting; // e.g., 22.5°C

    Thermostat(String deviceId, String status, double temperatureSetting) {
        super(deviceId, status);
        this.temperatureSetting = temperatureSetting;
    }

    @Override
    void displayStatus() {
        super.displayStatus(); // Display general device info
        System.out.println("Temperature Setting: " + temperatureSetting + "°C");
        System.out.println("Device Type: Thermostat");
    }
}
public class HomeDevices {
    public static void main(String[] args) {
        // Create thermostat devices
        Thermostat thermostat1 = new Thermostat("T1001", "ON", 22.5);
        Thermostat thermostat2 = new Thermostat("T1002", "OFF", 18.0);

        // Store in an array of Device type to demonstrate polymorphism
        Device[] devices = {thermostat1, thermostat2};

        System.out.println("=== Smart Home Devices ===\n");

        for (Device d : devices) {
            d.displayStatus();
            System.out.println("------------------------\n");
        }
    }
}
