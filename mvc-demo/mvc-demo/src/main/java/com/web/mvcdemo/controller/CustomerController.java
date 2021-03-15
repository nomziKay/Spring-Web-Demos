package com.web.mvcdemo.controller;

import com.web.mvcdemo.service.CustomerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/customers")
public class CustomerController {

    private CustomerService customerService;

    public CustomerController(final CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public ModelAndView getAllCustomers() {
        ModelAndView modelAndView = new ModelAndView("customers");
        modelAndView.addObject("welcomeMessage", "Welcome to the customer's portal");
        modelAndView.addObject("customers", customerService.getAll());
        return modelAndView;
    }

    @GetMapping("/{id}")
    public String getCustomerById(@PathVariable Long id,
                                  Model model) {
        model.addAttribute("customer", customerService.getById(id));
        return "customer";
    }

//    @GetMapping
//    public String getCustomerByName(@RequestParam("name") String customerName,
//                                    Model model) {
//        model.addAttribute("customer", customerService.getByName(customerName));
//        return "customer";
//    }

}
