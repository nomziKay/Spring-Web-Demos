package com.web.mvcdemo.service;

import com.web.mvcdemo.model.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerService {

    Customer save(Customer customer);

    List<Customer> getAll();

    Customer getById(Long id);

    void delete(Customer customer);

    Customer getByName(String customerName);
}
