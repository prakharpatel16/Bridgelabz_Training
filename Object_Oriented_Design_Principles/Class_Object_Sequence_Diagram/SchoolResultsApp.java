package Object_Oriented_Design_Principles.Class_Object_Sequence_Diagram;

import java.util.*;

// Subject class
class Subject {
    private String name;
    private int marks;

    public Subject(String name, int marks) {
        this.name = name;
        this.marks = marks;
    }

    public String getName() {
        return name;
    }

    public int getMarks() {
        return marks;
    }
}

// Student class (Aggregation: has multiple Subjects)
class Student {
    private String name;
    private List<Subject> subjects;

    public Student(String name) {
        this.name = name;
        this.subjects = new ArrayList<>();
    }

    public void addSubject(Subject subject) {
        subjects.add(subject);
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public String getName() {
        return name;
    }
}

// GradeCalculator class
class GradeCalculator {
    public String calculateGrade(Student student) {
        List<Subject> subjects = student.getSubjects();
        int total = 0;

        for (Subject subject : subjects) {
            total += subject.getMarks();
        }

        double avg = (double) total / subjects.size();

        if (avg >= 90) return "A";
        else if (avg >= 75) return "B";
        else if (avg >= 50) return "C";
        else return "F";
    }
}

// Main class for testing
public class SchoolResultsApp {
    public static void main(String[] args) {
        Student student = new Student("John");
        student.addSubject(new Subject("Maths", 90));
        student.addSubject(new Subject("Science", 85));

        GradeCalculator calculator = new GradeCalculator();
        String grade = calculator.calculateGrade(student);

        System.out.println("Student: " + student.getName());
        for (Subject s : student.getSubjects()) {
            System.out.println("Subject: " + s.getName() + " - Marks: " + s.getMarks());
        }
        System.out.println("Final Grade: " + grade);
    }
}
