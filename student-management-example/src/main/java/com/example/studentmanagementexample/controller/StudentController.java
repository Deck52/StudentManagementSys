package com.example.studentmanagementexample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.studentmanagementexample.model.Student;
import com.example.studentmanagementexample.service.StudentService;

import java.util.List;

// @RestController combines @Controller and @ResponseBody, meaning it's ready for REST APIs.
// @RequestMapping("/api/students") maps all methods in this class to a base URL.
@RestController
@RequestMapping("/api/students")
@CrossOrigin(origins = "*") // Allows your frontend to make requests from a different origin
public class StudentController {

    // @Autowired injects the StudentService instance.
    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    // Handles GET requests to /api/students
    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    // Handles GET requests to /api/students/{id}
    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable String id) {
        return studentService.getStudentById(id)
                .map(student -> new ResponseEntity<>(student, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Handles POST requests to /api/students
    @PostMapping
    public ResponseEntity<Student> addStudent(@RequestBody Student student) {
        // Here you might add validation logic before saving
        if (studentService.getStudentById(student.getId()).isPresent()) {
            return new ResponseEntity<>(null, HttpStatus.CONFLICT); // Return 409 if ID already exists
        }
        Student newStudent = studentService.addStudent(student);
        return new ResponseEntity<>(newStudent, HttpStatus.CREATED);
    }
}