// Student.java
public class Student {
    // Attributes or properties of a Student
    private String studentId;
    private String name;
    private double marks;

    // Constructor to initialize a new Student object
    public Student(String studentId, String name, double marks) {
        this.studentId = studentId;
        this.name = name;
        this.marks = marks;
    }

    // Getters to access the private attributes
    public String getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }

    public double getMarks() {
        return marks;
    }

    // Setter for marks, as they might be updated
    public void setMarks(double marks) {
        this.marks = marks;
    }

    // Override the toString() method for easy printing
    @Override
    public String toString() {
        return "Student ID: " + studentId + ", Name: " + name + ", Marks: " + marks;
    }
}