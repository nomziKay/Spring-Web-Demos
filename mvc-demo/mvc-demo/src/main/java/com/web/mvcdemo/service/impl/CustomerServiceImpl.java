package com.web.mvcdemo.service.impl;

import com.web.mvcdemo.model.Customer;
import com.web.mvcdemo.repository.CustomerRepository;
import com.web.mvcdemo.service.CustomerService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    private CustomerRepository customerRepository;

    public CustomerServiceImpl(final CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer save(final Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public List<Customer> getAll() {
        return customerRepository.findAll();
    }

    @Override
    public Customer getById(final Long id) {
        Optional<Customer> result = customerRepository.findById(id);
        if (result.isPresent()) {
            return result.get();
        } else {
            throw new RuntimeException("Customer with id: " + id + " not found");
        }
    }

    @Override
    public void delete(final Customer customer) {
        customerRepository.delete(customer);
    }

    @Override
    public Customer getByName(String customerName) {
        return customerRepository.findByFirstName(customerName);

    }
}
