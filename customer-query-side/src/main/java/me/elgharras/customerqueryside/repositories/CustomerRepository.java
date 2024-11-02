package me.elgharras.customerqueryside.repositories;

import me.elgharras.customerqueryside.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, String> {
}

