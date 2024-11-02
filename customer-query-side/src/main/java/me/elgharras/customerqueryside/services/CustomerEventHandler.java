package me.elgharras.customerqueryside.services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.elgharras.coreapi.events.CustomerCreatedEvent;
import me.elgharras.customerqueryside.entities.Customer;
import me.elgharras.customerqueryside.repositories.CustomerRepository;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@AllArgsConstructor
public class CustomerEventHandler {
    private CustomerRepository customerRepository;


    @EventHandler
    public void on(CustomerCreatedEvent event) {
        log.info("************************");
        log.info("Handling CustomerCreatedEvent: {}", event);
        Customer customer = new Customer();
        customer.setId(event.getId());
        customer.setName(event.getName());
        customer.setEmail(event.getEmail());

        customerRepository.save(customer);
    }


}
