package co.za.entelect.restclientdemo.rest.template.client.impl;

import co.za.entelect.restclientdemo.domain.CustomerDto;
import co.za.entelect.restclientdemo.rest.template.client.CustomerRestTemplateWebClient;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class CustomerRestTemplateWebClientImpl implements CustomerRestTemplateWebClient {

    private RestTemplate restTemplate;
    private String baseUrl="http://localhost:8080/customers";

    public CustomerRestTemplateWebClientImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public List<CustomerDto> getAllCustomers() {
       HttpHeaders httpHeaders = new HttpHeaders();
        HttpEntity<String> httpEntity = new HttpEntity<>(httpHeaders);

        ResponseEntity<List<CustomerDto>> response = restTemplate.exchange(baseUrl+"/all", HttpMethod.GET,httpEntity,
                new ParameterizedTypeReference<List<CustomerDto>>() {});
        return response.getBody();
    }

    @Override
    public CustomerDto save(CustomerDto customerDto) {
        HttpEntity<CustomerDto> httpEntity = new HttpEntity<>(new CustomerDto("Emily","Ngobese"));

        return restTemplate.postForObject(baseUrl+"/save",httpEntity,CustomerDto.class);
    }
}
