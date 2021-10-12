package com.example.encryptdemo;

import lombok.var;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing

public class EncryptDemoApplication {
    private static final Logger log = LoggerFactory.getLogger(EncryptDemoApplication.class);
    public static void main(String[] args) {
        SpringApplication.run(EncryptDemoApplication.class, args);

    }
    @Bean
    public CommandLineRunner demo(CustomerRepository repository) {
        return (args) -> {
            // save a few customers
            repository.save(new Customer("Jack", "Bauer"));

            log.info("");
        };
    }

}
