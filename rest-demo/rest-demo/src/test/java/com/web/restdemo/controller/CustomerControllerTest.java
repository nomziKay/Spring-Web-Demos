package com.web.restdemo.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.web.restdemo.dto.CustomerDto;
import com.web.restdemo.model.Customer;
import com.web.restdemo.service.CustomerService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(CustomerController.class)
class CustomerControllerTest {

    @MockBean
    ModelMapper modelMapper;
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private CustomerService customerService;

    @Test
    void getAllCustomers() throws Exception {
        List<CustomerDto> expectedResponse = Collections.singletonList(buildCustomerDto());
        when(customerService.findAll()).thenReturn(Collections.singletonList(buildCustomer()));
        when(modelMapper.map(buildCustomer(), CustomerDto.class)).thenReturn(buildCustomerDto());

        MvcResult mvcResult = mockMvc.perform(get("/customers"))
                .andExpect(status().isOk())
                .andReturn();

        String jsonResponse = mvcResult.getResponse().getContentAsString();
        ObjectMapper objectMapper = new ObjectMapper();
        List<CustomerDto> actualResponse = objectMapper.readValue(jsonResponse, new TypeReference<List<CustomerDto>>() {
        });

        assertFalse(actualResponse.isEmpty());
        assertEquals(expectedResponse, actualResponse);
    }

    @Test
    void saveCustomer() {
        //
    }

    private Customer buildCustomer() {
        Customer customer = new Customer("John", "Williams");
        customer.setId(1L);

        return customer;
    }

    private CustomerDto buildCustomerDto() {
        return new CustomerDto(1L, "John", "Williams");

    }
}
