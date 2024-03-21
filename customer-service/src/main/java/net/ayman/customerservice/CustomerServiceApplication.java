package net.ayman.customerservice;

import net.ayman.customerservice.config.GlobalConfig;
import net.ayman.customerservice.entities.Customer;
import net.ayman.customerservice.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
@EnableConfigurationProperties(GlobalConfig.class)
public class CustomerServiceApplication {

    public static void main(String[] args) {

        SpringApplication.run(CustomerServiceApplication.class, args);
    }
    @Bean
    CommandLineRunner commandLineRunner(CustomerRepository customerRepository){
        return args -> {
            List<Customer> customerList=List.of(
                    Customer.builder()
                            .firstname("test1")
                            .lastname("test")
                            .email("test1@gmail.com")
                            .build(),
                    Customer.builder()
                            .firstname("test2")
                            .lastname("test")
                            .email("test2@gmail.com")
                            .build()
            );
            customerRepository.saveAll(customerList);
        };
    }

}
