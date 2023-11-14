package com.codegym.controller;

import com.codegym.model.Girl;
import com.codegym.model.GirlForm;
import com.codegym.service.GirlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/girl")
public class GirlController {

    private final GirlService girlService;

    @Autowired
    public GirlController(GirlService girlService) {
        this.girlService = girlService;
    }

    @Value("${file_upload}")
    private String fileUpload;

    @GetMapping("")
    public ModelAndView showHome() {
        List<Girl> girls = girlService.findAll();
        ModelAndView modelAndView = new ModelAndView("home");
        modelAndView.addObject("girls", girls);
        return modelAndView;
    }

    @GetMapping("/add")
    public ModelAndView showFormAdd() {
        ModelAndView modelAndView = new ModelAndView("add");
        modelAndView.addObject("girlForm", new GirlForm());
        return modelAndView;
    }

    @PostMapping("/add")
    public String add(@ModelAttribute GirlForm girlForm, RedirectAttributes redirectAttributes) {
        MultipartFile file = girlForm.getImage();
        String nameImage = file.getOriginalFilename();
        try {
            FileCopyUtils.copy(file.getBytes(), new File(fileUpload + nameImage));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Girl girl1 = new Girl(girlForm.getId(), girlForm.getName(), nameImage);
        girlService.add(girl1);
        redirectAttributes.addFlashAttribute("message", "Thêm thành công");
        return "redirect:/girl";
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showFormEdit(@PathVariable int id) {
        ModelAndView modelAndView = new ModelAndView("edit");
        modelAndView.addObject("girl", girlService.findGirlById(id));
        return modelAndView;
    }

    @PostMapping("/edit/{id}")
    public String edit(@PathVariable int id, Girl girl, RedirectAttributes redirectAttributes) {
        girlService.update(id, girl);
        redirectAttributes.addFlashAttribute("message", "Sửa" + girl.getId() + "thành công");
        return "redirect:/girl";
    }


    @GetMapping("/search")
    public ModelAndView showSearch(@RequestParam String q) {
        List<Girl> girls;
        if (q.isEmpty()) girls = girlService.findAll();
        else girls = girlService.findByName(q);
        ModelAndView modelAndView = new ModelAndView("home");
        modelAndView.addObject("girls", girls);
        return modelAndView;
    }
}
