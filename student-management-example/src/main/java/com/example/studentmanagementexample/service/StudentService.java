package com.example.studentmanagementexample.service;

import org.springframework.stereotype.Service;

import com.example.studentmanagementexample.model.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

// @Service marks this class as a Spring service component.
// It contains the business logic for managing students.
@Service
public class StudentService {
    // We'll use an in-memory list to store students for now.
    // In a real application, this would be a database connection.
    private final List<Student> students = new ArrayList<>();

    // Initial student data for testing
    public StudentService() {
            students.add(new Student("101", "Alice Johnson", 95.5));
            students.add(new Student("102", "Bob Williams", 88.0));
        }
    

    // Get all students
    public List<Student> getAllStudents() {
        return students;
    }

    // Get a single student by ID
    public Optional<Student> getStudentById(String id) {
        return students.stream()
                .filter(student -> student.getId().equals(id))
                .findFirst();
    }

    // Add a new student
    public Student addStudent(Student student) {
        students.add(student);
        return student;
    }

    // Update an existing student's marks
    public Optional<Student> updateStudentMarks(String id, double newMarks) {
        Optional<Student> optionalStudent = getStudentById(id);
        if (optionalStudent.isPresent()) {
            Student student = optionalStudent.get();
            student.setMarks(newMarks);
            return Optional.of(student);
        }
        return Optional.empty();
    }

    // Remove a student
    public boolean deleteStudent(String id) {
        return students.removeIf(student -> student.getId().equals(id));
    }
}
