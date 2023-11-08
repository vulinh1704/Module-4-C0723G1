package com.codegym.controller;

import com.codegym.model.Student;
import com.codegym.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class HelloController {
    @Autowired
    private StudentService studentService;

    @GetMapping("/hello")
    public ModelAndView hello(){
        List<Student> list = studentService.findAll();
        ModelAndView modelAndView = new ModelAndView("hi");
        modelAndView.addObject("message", "Hello World");
        return modelAndView;
    }
}
