package com.web.restdemo.controller;

import com.web.restdemo.dto.CustomerDto;
import com.web.restdemo.model.Customer;
import com.web.restdemo.service.CustomerService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private CustomerService customerService;

    private ModelMapper modelMapper;

    public CustomerController(final CustomerService customerService, final ModelMapper modelMapper) {
        this.customerService = customerService;
        this.modelMapper = modelMapper;
    }

    @PostMapping("/save")
    public ResponseEntity<CustomerDto> saveCustomer(@RequestBody CustomerDto customerDto){
        //consider converting in the service layer and keep the db objects there
        Customer customer = modelMapper.map(customerDto,Customer.class);
        CustomerDto persistedCustomer = modelMapper.map(customerService.save(customer),CustomerDto.class);

        return new ResponseEntity<>(persistedCustomer, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<CustomerDto>> getAllCustomers(){
        List<CustomerDto> customerDtoList = customerService.findAll().stream()
                .map(customer -> modelMapper.map(customer,CustomerDto.class)).collect(Collectors.toList());

        return new ResponseEntity<>(customerDtoList,HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerDto>  getById(@PathVariable Long id){
        Customer customer = customerService.findById(id);
        CustomerDto customerDto = modelMapper.map(customer,CustomerDto.class);

        return new ResponseEntity<>(customerDto,HttpStatus.OK);
    }
}
