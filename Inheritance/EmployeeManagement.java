package Inheritance;
class Employee {
    String name;
    int id;
    double salary;

    Employee(String name, int id, double salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }

    void displayDetails() {
        System.out.println("Employee ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Salary: $" + salary);
    }
}

// Manager subclass
class Manager extends Employee {
    int teamSize;

    Manager(String name, int id, double salary, int teamSize) {
        super(name, id, salary);
        this.teamSize = teamSize;
    }

    @Override
    void displayDetails() {
        super.displayDetails();
        System.out.println("Team Size: " + teamSize);
        System.out.println("Role: Manager");
    }
}

// Developer subclass
class Developer extends Employee {
    String programmingLanguage;

    Developer(String name, int id, double salary, String programmingLanguage) {
        super(name, id, salary);
        this.programmingLanguage = programmingLanguage;
    }

    @Override
    void displayDetails() {
        super.displayDetails();
        System.out.println("Programming Language: " + programmingLanguage);
        System.out.println("Role: Developer");
    }
}

// Intern subclass
class Intern extends Employee {
    String university;

    Intern(String name, int id, double salary, String university) {
        super(name, id, salary);
        this.university = university;
    }

    @Override
    void displayDetails() {
        super.displayDetails();
        System.out.println("University: " + university);
        System.out.println("Role: Intern");
    }
}

// Main class
public class EmployeeManagement {
    public static void main(String[] args) {
        Employee manager = new Manager("Alice", 101, 90000, 5);
        Employee developer = new Developer("Bob", 102, 70000, "Java");
        Employee intern = new Intern("Charlie", 103, 20000, "MIT");

        Employee[] employees = {manager, developer, intern};

        System.out.println("=== Employee Management System ===\n");

        for (Employee e : employees) {
            e.displayDetails();
            System.out.println("-------------------------------\n");
        }
    }
}
