package com.codegym.controller;

import com.codegym.model.ClassRoom;
import com.codegym.model.Student;
import com.codegym.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class StudentController {
    @Autowired
    private IService<Student> studentService;

    @Autowired
    private IService<ClassRoom> classRoomIService;

    @GetMapping("/demo")
    public String showAll() {
        Iterable<Student> students = studentService.findAll();
        return "";
    }

    @GetMapping("/create")
    public ModelAndView showFormCreate() {
        ModelAndView modelAndView = new ModelAndView("add");
        modelAndView.addObject("student", new Student());

        return modelAndView;
    }

    @PostMapping("/create")
    public ModelAndView create(@Validated @ModelAttribute Student student, BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            return new ModelAndView("add");
        } else {
            studentService.save(student);
            return new ModelAndView("success");
        }
    }

    @GetMapping("update")
    public String update() {
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

    @GetMapping("findByClass/{id}")
    public String showStudentFromClass(@PathVariable Long id) {
        ClassRoom classRoom = classRoomIService.findOneById(id).get();
        List<Student> students = studentService.findByClassroom(classRoom);
        return "";
    }

}
