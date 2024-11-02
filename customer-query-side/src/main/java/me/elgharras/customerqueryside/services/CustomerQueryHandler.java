package me.elgharras.customerqueryside.services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.elgharras.coreapi.query.GetAllCustomerQuery;
import me.elgharras.coreapi.query.GetCustomerByIdQuery;
import me.elgharras.customerqueryside.entities.Customer;
import me.elgharras.customerqueryside.repositories.CustomerRepository;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class CustomerQueryHandler {
    public CustomerRepository customerRepository;

    @QueryHandler
    public List<Customer> customerList(GetAllCustomerQuery query) {
        return customerRepository.findAll();
    }

    @QueryHandler
    public Customer customer(GetCustomerByIdQuery query) {
        return customerRepository.findById(query.getId())
                .orElseThrow(()->new RuntimeException("Customer not found"));
    }
}
