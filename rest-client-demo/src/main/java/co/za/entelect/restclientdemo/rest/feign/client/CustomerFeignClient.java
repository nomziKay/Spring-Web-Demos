package co.za.entelect.restclientdemo.rest.feign.client;

import co.za.entelect.restclientdemo.domain.CustomerDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "CustomerAPI", url = "http://localhost:8080/customers")
public interface CustomerFeignClient {

    @GetMapping
    List<CustomerDto> findAll();

}
