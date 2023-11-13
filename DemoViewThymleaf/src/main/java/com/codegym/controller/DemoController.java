package com.codegym.controller;

import com.codegym.model.Police;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

@Controller
public class DemoController {
    List<Police> polices = new ArrayList<>();
    public DemoController() {
        polices.add(new Police(1, "Hồng", "Thượng sĩ"));
        polices.add(new Police(2, "Thái", "Thượng tá"));
    }

    @GetMapping("/demo")
    public ModelAndView showHome(){
        ModelAndView modelAndView = new ModelAndView("home");
//        modelAndView.addObject("message", "Thượng sĩ Hồng");
        modelAndView.addObject("polices", polices);
        return modelAndView;
    }

    @GetMapping("/add")
    public ModelAndView showFormAdd() {
        ModelAndView modelAndView = new ModelAndView("add");
        modelAndView.addObject("police", new Police());
        return modelAndView;
    }


    @PostMapping("/add")
    public String add(Police police, RedirectAttributes redirectAttributes) {
        polices.add(police);
        redirectAttributes.addFlashAttribute("message", "Thêm thành công");
        return "redirect:/demo";
    }

    @GetMapping("/demo2")
    public ModelAndView showDemo() {
        ModelAndView modelAndView = new ModelAndView("demo");
        modelAndView.addObject("message", "Linh");
        return modelAndView;
    }



}
