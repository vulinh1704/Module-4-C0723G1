package com.codegym.controller;

import com.codegym.model.Student;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    @GetMapping("hello")
    public ModelAndView hello() {
        ModelAndView modelAndView = new ModelAndView("home");
        modelAndView.addObject("name", "Hong J2k5");
        return modelAndView;
    }

    @GetMapping("{name}")
    public ModelAndView showInfo(@PathVariable String name){
        ModelAndView modelAndView = new ModelAndView("showParam");
        modelAndView.addObject("pathVariable", name);
        return modelAndView;
    }

    @GetMapping("/search")
    public ModelAndView search(@RequestParam String q){
        ModelAndView modelAndView = new ModelAndView("showParam");
        modelAndView.addObject("q", q);
        return modelAndView;
    }

    @GetMapping("/show")
    public ModelAndView showForm(Model model){
        Student student = new Student();
        model.addAttribute("student", student);
        ModelAndView modelAndView = new ModelAndView("create");
        return modelAndView;
    }

    @PostMapping("/showDataForm")
    public ModelAndView showDataForm(@ModelAttribute("student") Student student){
        System.out.println(student);
        return new ModelAndView();
    }
}
