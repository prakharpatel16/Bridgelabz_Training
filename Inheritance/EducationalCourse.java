package Inheritance;
// Base class Course
class Course {
    String courseName;
    int duration; // in hours

    Course(String courseName, int duration) {
        this.courseName = courseName;
        this.duration = duration;
    }

    // Method to display course info
    void displayInfo() {
        System.out.println("Course Name: " + courseName);
        System.out.println("Duration: " + duration + " hours");
    }
}
// Subclass OnlineCourse
class OnlineCourse extends Course {
    String platform;
    boolean isRecorded;

    OnlineCourse(String courseName, int duration, String platform, boolean isRecorded) {
        super(courseName, duration);
        this.platform = platform;
        this.isRecorded = isRecorded;
    }

    @Override
    void displayInfo() {
        super.displayInfo();
        System.out.println("Platform: " + platform);
        System.out.println("Recorded: " + (isRecorded ? "Yes" : "No"));
    }
}
// Subclass PaidOnlineCourse
class PaidOnlineCourse extends OnlineCourse {
    double fee;
    double discount; // in percentage

    PaidOnlineCourse(String courseName, int duration, String platform, boolean isRecorded, double fee, double discount) {
        super(courseName, duration, platform, isRecorded);
        this.fee = fee;
        this.discount = discount;
    }

    double calculateFinalFee() {
        return fee - (fee * discount / 100);
    }

    @Override
    void displayInfo() {
        super.displayInfo();
        System.out.println("Fee: $" + fee);
        System.out.println("Discount: " + discount + "%");
        System.out.println("Final Fee: $" + calculateFinalFee());
        System.out.println("Course Type: Paid Online Course");
    }
}
public class EducationalCourse {
    public static void main(String[] args) {
        // Create courses
        Course course1 = new Course("Mathematics", 40);
        OnlineCourse course2 = new OnlineCourse("Java Programming", 60, "Coursera", true);
        PaidOnlineCourse course3 = new PaidOnlineCourse("Data Science", 80, "Udemy", false, 500, 20);

        Course[] courses = {course1, course2, course3};

        System.out.println("=== Educational Course Hierarchy ===\n");

        for (Course c : courses) {
            c.displayInfo();
            System.out.println("-----------------------------\n");
        }
    }
}
