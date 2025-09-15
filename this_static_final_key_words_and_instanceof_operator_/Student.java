public class Student {
    // ---------- STATIC ----------
    private static String universityName;
    private static int totalStudents = 0;

    // ---------- INSTANCE VARIABLES ----------
    private final int rollNumber; // unique & immutable
    private String name;
    private char grade;

    // ---------- CONSTRUCTOR (using 'this') ----------
    public Student(String name, int rollNumber, char grade) {
        this.name = name;
        this.rollNumber = rollNumber;   // final → assigned only once
        this.grade = grade;
        totalStudents++;
    }

    // ---------- STATIC METHODS ----------
    public static void setUniversityName(String name) {
        universityName = name;
    }

    public static void displayTotalStudents() {
        System.out.println("Total Students Enrolled: " + totalStudents);
    }

    // ---------- INSTANCE METHODS ----------
    public void displayStudentDetails() {
        if (this instanceof Student) { // safe check
            System.out.println("University Name: " + universityName);
            System.out.println("Roll Number: " + rollNumber);
            System.out.println("Name: " + name);
            System.out.println("Grade: " + grade);
        } else {
            System.err.println("❌ The object is not an instance of Student.");
        }
    }

    public void updateGrade(char newGrade) {
        if (this instanceof Student) { // safe check
            this.grade = newGrade;
            System.out.println("✅ Grade updated to: " + newGrade);
        } else {
            System.err.println("❌ Invalid object. Cannot update grade.");
        }
    }

    // ---------- GETTERS ----------
    public String getName() {
        return name;
    }
    public int getRollNumber() {
        return rollNumber;
    }
    public char getGrade() {
        return grade;
    }

    // ---------- MAIN ----------
    public static void main(String[] args) {
        // Set university name (shared)
        Student.setUniversityName("Global University");

        // Create students
        Student student1 = new Student("Hemashree", 101, 'A');
        Student student2 = new Student("Sharmila", 102, 'B');

        // Display total
        Student.displayTotalStudents();

        // Display details
        student1.displayStudentDetails();
        System.out.println();
        student2.displayStudentDetails();

        // Update grade
        System.out.println();
        student2.updateGrade('A');

        // Display updated details
        System.out.println();
        student2.displayStudentDetails();
    }
}
