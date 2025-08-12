// App.java
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
    // ArrayList to store Student objects
    private static ArrayList<Student> studentList = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice = 0;
        do {
            showMenu();
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    removeStudent();
                    break;
                case 3:
                    updateStudent();
                    break;
                case 4:
                    listStudents();
                    break;
                case 5:
                    System.out.println("Exiting Student Management System. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 5);
        scanner.close();
    }

    // Method to display the menu
    private static void showMenu() {
        System.out.println("\n--- Student Management System ---");
        System.out.println("1. Add a new student");
        System.out.println("2. Remove a student");
        System.out.println("3. Update a student's marks");
        System.out.println("4. List all students");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
    }

    private static boolean isNumeric(String str) {
    if (str == null || str.isEmpty()) {
        return false;
    }
    for (char c : str.toCharArray()) {
        if (!Character.isDigit(c)) {
            return false;
        }
    }
    return true;
}

    // Method to add a new student
    private static void addStudent() {
    String id = ""; // Initialize id to an empty string
    boolean isValidId = false;

    while (!isValidId) {
        System.out.print("Enter student ID (numeric only): ");
        id = scanner.nextLine();
        if (isNumeric(id)) {
            isValidId = true;
        } else {
            System.out.println("Invalid ID. Please enter a numeric ID.");
        }
    }
    System.out.print("Enter student name: ");
    String name = scanner.nextLine();

    double marks = -1; // Initialize with a default value
    boolean isValidInput = false;

    // Loop until a valid numeric input is received
    while (!isValidInput) {
        System.out.print("Enter student marks (e.g., 85.5): ");
        try {
            marks = scanner.nextDouble();
            isValidInput = true; // Set to true to exit the loop
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a number for marks.");
        } finally {
            scanner.nextLine(); // Always consume the newline character
        }
    }

    Student newStudent = new Student(id, name, marks);
    studentList.add(newStudent);
    System.out.println("Student added successfully!");
}

    // Method to remove a student
    private static void removeStudent() {
        System.out.print("Enter student ID to remove: ");
        String idToRemove = scanner.nextLine();
        boolean found = false;

        // Iterate through the list to find and remove the student
        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).getStudentId().equals(idToRemove)) {
                studentList.remove(i);
                found = true;
                System.out.println("Student removed successfully!");
                break;
            }
        }

        if (!found) {
            System.out.println("Student with ID " + idToRemove + " not found.");
        }
    }

    // Method to update a student's marks
    private static void updateStudent() {
        System.out.print("Enter student ID to update marks: ");
        String idToUpdate = scanner.nextLine();
        boolean found = false;

        for (Student s : studentList) {
            if (s.getStudentId().equals(idToUpdate)) {
                System.out.print("Enter new marks: ");
                double newMarks = scanner.nextDouble();
                scanner.nextLine();
                s.setMarks(newMarks);
                found = true;
                System.out.println("Student marks updated successfully!");
                break;
            }
        }

        if (!found) {
            System.out.println("Student with ID " + idToUpdate + " not found.");
        }
    }

    // Method to list all students
    private static void listStudents() {
        if (studentList.isEmpty()) {
            System.out.println("No students found.");
        } else {
            System.out.println("\n--- List of Students ---");
            for (Student s : studentList) {
                System.out.println(s); // Uses the overridden toString() method
            }
        }
    }
}
