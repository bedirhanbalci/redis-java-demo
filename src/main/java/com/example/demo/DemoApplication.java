package com.example.demo;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

    @Bean
    public ApplicationRunner runner(CustomerRepository customerRepository) {
        return args -> {
    	Customer customer = new Customer(
  				  "49106381", "Bedirhan Balci");
  		customerRepository.save(customer);
  		Customer retrievedCustomer = customerRepository.findById("49106381").get();
  		System.out.println(retrievedCustomer.toString());
        };
    }
}
