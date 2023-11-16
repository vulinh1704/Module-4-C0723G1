package com.codegym.controller;

import com.codegym.model.Student;
import com.codegym.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping("/demo")
    public String showAll() {
        List<Student> studentList = studentService.findAll();
        return "";
    }


    @GetMapping("/form-add")
    public ModelAndView showFormAdd() {
        ModelAndView modelAndView = new ModelAndView("add");
        modelAndView.addObject("student", new Student());
        return modelAndView;
    }

    @PostMapping("/add")
    public String add(Student student) {
        studentService.save(student);
        return "";
    }
}
