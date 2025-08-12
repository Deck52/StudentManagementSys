package com.example.studentmanagementexample.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// @Data is a Lombok annotation that generates getters, setters, toString(), etc.
// @AllArgsConstructor generates a constructor with all fields.
// @NoArgsConstructor generates a default constructor with no arguments.
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    private String id;
    private String name;
    private double marks;
}