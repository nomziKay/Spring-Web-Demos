package com.web.restdemo.service.impl;

import com.web.restdemo.exception.CustomerNotFoundException;
import com.web.restdemo.model.Customer;
import com.web.restdemo.repository.CustomerRepository;
import com.web.restdemo.service.CustomerService;
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
        if (null != result) {
            return result.get();
        } else {
            throw new CustomerNotFoundException(id);
        }
    }

    @Override
    public void delete(final Customer customer) {
        customerRepository.delete(customer);
    }
}
