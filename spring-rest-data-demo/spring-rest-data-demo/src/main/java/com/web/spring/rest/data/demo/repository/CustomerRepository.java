package com.web.spring.rest.data.demo.repository;

import com.web.spring.rest.data.demo.model.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
}



