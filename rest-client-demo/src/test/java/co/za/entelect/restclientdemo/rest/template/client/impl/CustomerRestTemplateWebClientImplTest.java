package co.za.entelect.restclientdemo.rest.template.client.impl;

import co.za.entelect.restclientdemo.RestClientDemoApplication;
import co.za.entelect.restclientdemo.domain.CustomerDto;
import co.za.entelect.restclientdemo.rest.template.client.CustomerRestTemplateWebClient;
import co.za.entelect.restclientdemo.rest.template.client.config.ApppConfig;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.method;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

@RunWith(SpringRunner.class)
@SpringBootTest
class CustomerRestTemplateWebClientImplTest {

    private MockRestServiceServer mockRestServiceServer;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private CustomerRestTemplateWebClient customerRestTemplateWebClient;

    @BeforeEach
    public void setup(){
        mockRestServiceServer = MockRestServiceServer.createServer(restTemplate);
    }

    @Test
    void getAllCustomers() {
        String responseBody = "[{\"id\" : \"1\", \"name\" : \"Emily\", \"LastName\" : \"Ngobese\"}]";
        mockRestServiceServer.expect(requestTo("http://localhost:8080/customers/all"))
                .andExpect(method(HttpMethod.GET))
                .andRespond(withSuccess(responseBody, MediaType.APPLICATION_JSON));

        List<CustomerDto> customerDtoList = customerRestTemplateWebClient.getAllCustomers();

        //only verify the request since the response was mocked
        this.mockRestServiceServer.verify();
    }

    @Test
    void save() {
        //TODO
    }
}
