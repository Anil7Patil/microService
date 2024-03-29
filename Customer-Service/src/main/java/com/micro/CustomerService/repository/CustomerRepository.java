package com.micro.CustomerService.repository;
import org.springframework.data.jpa.repository.JpaRepository;


import com.micro.CustomerService.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Customer findByEmail(String email);
    // Additional custom queries can be added here if needed
}

