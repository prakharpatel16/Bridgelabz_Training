package PolymorphismAbstractionInterface_Problems; 
interface MedicalRecord {
 void addRecord(String record);
 void viewRecords();
} 
abstract class Patient {
 private String patientId;
 private String name;
 private int age;

 public Patient(String patientId, String name, int age) {
     this.patientId = patientId;
     this.name = name;
     this.age = age;
 }

 public void getPatientDetails() {
     System.out.println("ID: " + patientId + ", Name: " + name + ", Age: " + age);
 }

 public abstract double calculateBill();
} 
class InPatient extends Patient implements MedicalRecord {
 private double roomCharge;
 private double treatmentCost;
 private String record;

 public InPatient(String id, String name, int age, double roomCharge, double treatmentCost) {
     super(id, name, age);
     this.roomCharge = roomCharge;
     this.treatmentCost = treatmentCost;
 }

 @Override
 public double calculateBill() {
     return roomCharge + treatmentCost;
 }

 @Override
 public void addRecord(String record) { this.record = record; }

 @Override
 public void viewRecords() { System.out.println("Record: " + record); }
}

class OutPatient extends Patient implements MedicalRecord {
 private double consultationFee;
 private String record;

 public OutPatient(String id, String name, int age, double fee) {
     super(id, name, age);
     this.consultationFee = fee;
 }

 @Override
 public double calculateBill() {
     return consultationFee;
 }

 @Override
 public void addRecord(String record) { this.record = record; }

 @Override
 public void viewRecords() { System.out.println("Record: " + record); }
} 
public class HospitalSystem {
 public static void main(String[] args) {
     Patient[] patients = {
         new InPatient("P001", "Alice", 30, 5000, 10000),
         new OutPatient("P002", "Bob", 40, 1000)
     };

     for (Patient p : patients) {
         p.getPatientDetails();
         System.out.println("Bill: " + p.calculateBill());
         if (p instanceof MedicalRecord) {
             ((MedicalRecord) p).addRecord("General Checkup");
             ((MedicalRecord) p).viewRecords();
         }
         System.out.println(" ");
     }
 }
}

