package PolymorphismAbstractionInterface_Problems;
interface GPS {
 String getCurrentLocation();
 void updateLocation(String newLocation);
}
abstract class RideVehicle {
 private String vehicleId;
 private String driverName;
 private double ratePerKm;

 public RideVehicle(String vehicleId, String driverName, double ratePerKm) {
     this.vehicleId = vehicleId;
     this.driverName = driverName;
     this.ratePerKm = ratePerKm;
 }

 public String getDriverName() { return driverName; }
 public double getRatePerKm() { return ratePerKm; }

 public void getVehicleDetails() {
     System.out.println("Vehicle ID: " + vehicleId + ", Driver: " + driverName);
 }

 public abstract double calculateFare(double distance);
}
class RideCar extends RideVehicle implements GPS {
 private String location;

 public RideCar(String id, String driver, double rate) {
     super(id, driver, rate);
 }

 @Override
 public double calculateFare(double distance) {
     return distance * getRatePerKm();
 }

 @Override
 public String getCurrentLocation() { return location; }

 @Override
 public void updateLocation(String newLocation) { this.location = newLocation; }
}

class RideBike extends RideVehicle implements GPS {
 private String location;

 public RideBike(String id, String driver, double rate) {
     super(id, driver, rate);
 }

 @Override
 public double calculateFare(double distance) {
     return distance * getRatePerKm() * 0.8;
 }

 @Override
 public String getCurrentLocation() { return location; }

 @Override
 public void updateLocation(String newLocation) { this.location = newLocation; }
}

class RideAuto extends RideVehicle implements GPS {
 private String location;

 public RideAuto(String id, String driver, double rate) {
     super(id, driver, rate);
 }

 @Override
 public double calculateFare(double distance) {
     return distance * getRatePerKm() * 1.2;
 }

 @Override
 public String getCurrentLocation() { return location; }

 @Override
 public void updateLocation(String newLocation) { this.location = newLocation; }
}
public class RideHailingApp {
 public static void main(String[] args) {
     RideVehicle[] rides = {
         new RideCar("CAR01", "Alice", 15),
         new RideBike("BIKE02", "Bob", 10),
         new RideAuto("AUTO03", "Charlie", 12)
     };

     double distance = 10;
     for (RideVehicle v : rides) {
         v.getVehicleDetails();
         System.out.println("Fare for " + distance + " km: " + v.calculateFare(distance));
         if (v instanceof GPS) {
             ((GPS) v).updateLocation("City Center");
             System.out.println("Location: " + ((GPS) v).getCurrentLocation());
         }
         System.out.println(" ");
     }
 }
}



