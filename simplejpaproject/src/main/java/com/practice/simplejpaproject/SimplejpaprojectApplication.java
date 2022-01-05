package com.practice.simplejpaproject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.practice.customerjpa.Customer;
import com.practice.customerjpa.CustomerRepository;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses=CustomerRepository.class)
@EntityScan("com.practice.customerjpa")
public class SimplejpaprojectApplication {

	public static void main(String[] args) {
		SpringApplication.run(SimplejpaprojectApplication.class, args);
	}
	
	private static final Logger log=LoggerFactory.getLogger(SimplejpaprojectApplication.class);
	
	/*Using Command Line Runner to execute the below code as soon as the application launches */ 
	@Bean
	public CommandLineRunner jpademo(CustomerRepository repository) {
		
		return(args)->{
			repository.save(new Customer("sonam","matani"));
			repository.save(new Customer("Walter","Brian"));
			repository.save(new Customer("Happy","Quin"));
			repository.save(new Customer("Robert","Patrick"));
			repository.save(new Customer("Lolo","Jen"));
			repository.save(new Customer("bhuu","matani"));

			
			log.info("Customers with findAll(): ");
			log.info("-----------------------------------------------------------------------------------");
			for(Customer customer:repository.findAll()) {
				log.info(customer.toString());
			}
			log.info("");
			
			Customer customer=repository.findById(1L);
			log.info("Customer found by findById(1L)");
			log.info("-----------------------------------------------------------------------------------");
			log.info(customer.toString());
			log.info("");
			
			log.info("Fetching customer by last name");
			repository.findBylastname("matani").forEach(patricks->{
				log.info(patricks.toString());
			});
		};
	}
}
