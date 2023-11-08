package com.codegym.service;

import com.codegym.model.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentService {
    List<Student> students = new ArrayList<>();
    public StudentService() {
        students.add(new Student(1, "Linh"));
    }

    public List<Student> findAll() {
        return this.students;
    }
}
