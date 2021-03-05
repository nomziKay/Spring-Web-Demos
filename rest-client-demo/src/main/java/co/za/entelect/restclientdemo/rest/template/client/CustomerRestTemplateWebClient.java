package co.za.entelect.restclientdemo.rest.template.client;

import co.za.entelect.restclientdemo.domain.CustomerDto;

import java.util.List;

public interface CustomerRestTemplateWebClient {

    List<CustomerDto> getAllCustomers();

    CustomerDto save(CustomerDto customerDto);
}
