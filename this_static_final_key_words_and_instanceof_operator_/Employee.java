// Employee class
public class Employee {
    // ---------- STATIC ----------
    private static String companyName;       // shared by all employees
    private static int totalEmployees = 0;   // shared counter

    // ---------- INSTANCE VARIABLES ----------
    private String name;
    private final int id; // final ensures ID cannot be changed
    private String designation;

    // ---------- CONSTRUCTOR (using 'this') ----------
    public Employee(String name, int id, String designation) {
        this.name = name;              // 'this' removes ambiguity
        this.id = id;                  // final assigned only once
        this.designation = designation;
        totalEmployees++;              // shared value incremented
    }

    // ---------- STATIC METHODS ----------
    public static void setCompanyName(String name) {
        companyName = name;
    }

    public static void displayTotalEmployees() {
        System.out.println("Total Employees: " + totalEmployees);
    }

    // ---------- INSTANCEOF + DISPLAY ----------
    public void displayEmployeeDetails() {
        if (this instanceof Employee) { // safe type check
            System.out.println("Company Name: " + companyName);
            System.out.println("Employee ID: " + id);
            System.out.println("Name: " + name);
            System.out.println("Designation: " + designation);
        } else {
            System.err.println("The object is not an instance of the Employee class.");
        }
    }

    // ---------- GETTERS ----------
    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public String getDesignation() {
        return designation;
    }

    // ---------- MAIN ----------
    public static void main(String[] args) {
        // Set company name (shared across all employees)
        Employee.setCompanyName("Tech Solutions Inc.");

        // Create employee objects
        Employee emp1 = new Employee("Thamarai", 101, "Software Engineer");
        Employee emp2 = new Employee("Rohan", 102, "Project Manager");

        // Show total employees
        Employee.displayTotalEmployees();

        // Show employee details
        emp1.displayEmployeeDetails();
        emp2.displayEmployeeDetails();
    }
}
