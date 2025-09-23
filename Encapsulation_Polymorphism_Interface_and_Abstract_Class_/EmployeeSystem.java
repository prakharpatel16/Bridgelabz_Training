package PolymorphismAbstractionInterface_Problems;
interface Department {
 void assignDepartment(String dept);
 void getDepartmentDetails();
}
abstract class Employee {
 private int employeeId;
 private String name;
 private double baseSalary;

 public Employee(int employeeId, String name, double baseSalary) {
     this.employeeId = employeeId;
     this.name = name;
     this.baseSalary = baseSalary;
 }
 public int getEmployeeId() { return employeeId; }
 public String getName() { return name; }
 public double getBaseSalary() { return baseSalary; }
 public void setBaseSalary(double baseSalary) { this.baseSalary = baseSalary; }

 public void displayDetails() {
     System.out.println("ID: " + employeeId + ", Name: " + name + ", Base Salary: " + baseSalary);
 }

 public abstract double calculateSalary();
}
class FullTimeEmployee extends Employee implements Department {
 private String department;

 public FullTimeEmployee(int id, String name, double baseSalary) {
     super(id, name, baseSalary);
 }

 @Override
 public double calculateSalary() {
     return getBaseSalary();
 }

 @Override
 public void assignDepartment(String dept) { this.department = dept; }

 @Override
 public void getDepartmentDetails() {
     System.out.println("Department: " + department);
 }
}

class PartTimeEmployee extends Employee implements Department {
 private String department;
 private int hoursWorked;
 private double ratePerHour;

 public PartTimeEmployee(int id, String name, double ratePerHour, int hoursWorked) {
     super(id, name, 0);
     this.ratePerHour = ratePerHour;
     this.hoursWorked = hoursWorked;
 }

 @Override
 public double calculateSalary() {
     return ratePerHour * hoursWorked;
 }

 @Override
 public void assignDepartment(String dept) { this.department = dept; }

 @Override
 public void getDepartmentDetails() {
     System.out.println("Department: " + department);
 }
}
public class EmployeeSystem {
 public static void main(String[] args) {
     Employee e1 = new FullTimeEmployee(101, "Alice", 50000);
     Employee e2 = new PartTimeEmployee(102, "Bob", 500, 40);

     Employee[] employees = {e1, e2};
     for (Employee e : employees) {
         e.displayDetails();
         System.out.println("Calculated Salary: " + e.calculateSalary());
         System.out.println(" ");
     }
 }
}

