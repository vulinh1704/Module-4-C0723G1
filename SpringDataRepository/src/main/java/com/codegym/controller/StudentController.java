package com.codegym.controller;

import com.codegym.model.Student;
import com.codegym.service.IService;
import com.codegym.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class StudentController {
    @Autowired
    private IService<Student> studentService;

    @GetMapping("/demo")
    public String showAll() {
        Iterable<Student> students = studentService.findAll();
        return "";
    }

    @GetMapping("create")
    public String create() {
        Student student = new Student();
        student.setImage("bcd.jpg");
        student.setName("Linh");
        studentService.save(student);
        return "";
    }

    @GetMapping("update")
    public String update() {
        Student student = new Student();
        student.setId(3);
        student.setImage("bcd.jpg");
        student.setName("Thắng FuckBoy");
        studentService.save(student);
        return "";
    }

    @GetMapping("delete")
    public String delete() {
        studentService.delete(1);
        return "";
    }

    @GetMapping("find_name")
    public String search() {
        List<Student> students = studentService.findByNameContain("s");
        return "";
    }

    @GetMapping("find_custom")
    public String find() {
       Student students = studentService.findStudentById(2);
        return "";
    }

}
