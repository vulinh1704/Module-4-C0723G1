package com.codegym.controller;

import com.codegym.model.Address;
import com.codegym.model.Class;
import com.codegym.model.Student;
import com.codegym.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping("/demo")
    public String showAll() {
        List<Student> students = studentService.findAll();
        return "";
    }

    @GetMapping("create")
    public String create() {
        Student student = new Student();
        student.setName("Linh2");
        student.setImage("hhh.abc");
        student.setAddress(new Address(4, null));
        student.setClazz(new Class(2, null));
        studentService.save(student);
        return "";
    }

}
