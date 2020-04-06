package com.web.mvcdemo.controller;

import com.web.mvcdemo.model.Customer;
import com.web.mvcdemo.service.CustomerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@RequestMapping("/customers")
public class CustomerController {

    private CustomerService customerService;

    public CustomerController(final CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/all")
    public ModelAndView getAllCustomers() {
        ModelAndView model = new ModelAndView("customers");
        model.addObject("welcomeMessage", "Welcome to the customer's portal");
        model.addObject("customers", customerService.getAll());
        return model;
    }

    @GetMapping("/{id}")
    public String getCustomer(@PathVariable Long id,
                              Model model) {
        model.addAttribute("customer", customerService.getById(id));
        return "customer";
    }
}
