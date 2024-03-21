package net.ayman.accountservice.clients;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import net.ayman.accountservice.model.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
@FeignClient(name = "customer-service")
public interface CustomerRestClient {
    @GetMapping("/customers/{id}")
    @CircuitBreaker(name = "customerService", fallbackMethod = "getDefaultCustomer")
    Customer findCustomerById(@PathVariable Long id);
    @GetMapping("/customers")
    @CircuitBreaker(name = "customerService", fallbackMethod = "getAllCustomers")
    List<Customer> allCustomers();
    default Customer getDefaultCustomer(Long id,Exception exception){
        Customer customer=new Customer();
        customer.setId(id);
        customer.setFirstname("not available");
        customer.setLastname("not available");
        customer.setEmail("not available");
        return customer;

    }
    default List<Customer> getAllCustomers(Exception exception){
        return List.of();
    }
}
