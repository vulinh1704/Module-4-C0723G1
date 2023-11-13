package com.codegym.controller;

import com.codegym.model.Product;
import com.codegym.model.ProductForm;
import com.codegym.service.IProductService;
import com.codegym.service.ProductService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
public class ProductController {
    private final IProductService productService = new ProductService();

    @Value("${file-upload}")
    private String fileUpload;
    @GetMapping("/demo")
    public String index(Model model) {
        List<Product> products = productService.findAll();
        model.addAttribute("products", products);
        return "index";
    }

    @GetMapping("/create")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("add");
        modelAndView.addObject("productForm", new ProductForm());
        return modelAndView;
    }

    @PostMapping("/save")
    public String saveProduct(@ModelAttribute ProductForm productForm) {
        MultipartFile multipartFile = productForm.getImage();
        String fileName = multipartFile.getOriginalFilename();
        try {
            FileCopyUtils.copy(multipartFile.getBytes(), new File(fileUpload + fileName));
        } catch (IOException ex) {
            System.out.println(ex);
        }
        Product product = new Product(productForm.getId(), productForm.getName(), productForm.getDescription(), fileName);
        productService.save(product);
        return "redirect:/demo";
    }
}
