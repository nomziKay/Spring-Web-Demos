package com.web.restdemo.service;

import com.web.restdemo.model.Customer;

import java.util.List;

public interface CustomerService {

    Customer save(Customer customer);

    List<Customer> getAll();

    Customer getById(Long id);

    void delete(Customer customer);
}
