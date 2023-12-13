package org.sid.customerservice;


import org.sid.customerservice.entities.Customer;
import org.sid.customerservice.repo.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CustomerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner start(CustomerRepository customerRepository){
		return args ->{
			customerRepository.saveAll(List.of(
					Customer.builder().name("Ilyas").email("ilyas@gmail.com").build(),
					Customer.builder().name("badre").email("badre@gmail.com").build(),
					Customer.builder().name("walid").email("walid@gmail.com").build()
			));
			customerRepository.findAll().forEach(System.out::println);
			//a refaire avec les bonnes pratiques, couche service,doa,
		};
	}
}
