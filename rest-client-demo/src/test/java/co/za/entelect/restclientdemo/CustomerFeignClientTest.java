package co.za.entelect.restclientdemo;

import co.za.entelect.restclientdemo.domain.CustomerDto;
import co.za.entelect.restclientdemo.rest.feign.client.CustomerFeignClient;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class CustomerFeignClientTest {

    @Autowired
    private CustomerFeignClient customerFeignClient;

    @Test
    public void getAllCustomers() {
        //TODO: Make sure the REST API is up and running otherwise this test will fail
        List<CustomerDto> customers = customerFeignClient.findAll();

        System.out.println(customers);
    }
}
