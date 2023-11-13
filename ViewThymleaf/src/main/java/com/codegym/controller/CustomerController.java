package com.codegym.controller;

import com.codegym.model.Customer;
import com.codegym.service.IService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/customers")
public class CustomerController {
    private final IService customerService;

    @Autowired
    public CustomerController(IService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("")
    public String index(Model model) {
        List<Customer> customerList = customerService.findAll();
        model.addAttribute("customers", customerList);
        return "/index";
    }




    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("customer", new Customer());
        return "/add";
    }

    @PostMapping("/save")
    public String save(Customer customer, RedirectAttributes redirectAttributes) {
        customer.setId((int) (Math.random() * 100000));
        customerService.save(customer);
        redirectAttributes.addFlashAttribute("success", "Add customer success");
        return "redirect:/customers";
    }

    @GetMapping("hello")
    public String demo(Model model) {
        model.addAttribute("message", "Linh đẹp trai");
        return "/demo";
    }



}
