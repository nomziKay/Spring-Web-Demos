package com.web.mvcdemo.repository.config;

import com.web.mvcdemo.model.Customer;
import com.web.mvcdemo.repository.CustomerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class RepositoryConfig {

    @Bean
    CommandLineRunner initDatabase(CustomerRepository repository) {
        return args -> {
            log.info("Preloading " + repository.save(new Customer("John", "Williams")));
            log.info("Preloading " + repository.save(new Customer("Frodo", "Lou")));
            log.info("Preloading " + repository.save(new Customer("Zodwa", "Mkhize")));
        };
    }
}

