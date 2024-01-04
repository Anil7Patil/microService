package com.micro.CustomerService.service;
import java.util.List;

import com.micro.CustomerService.model.Customer;

public interface CustomerService {

    List<Customer> getAllCustomers();

    Customer getCustomerById(Long id);

    Customer createCustomer(Customer customer);

    Customer updateCustomer(Long id, Customer updatedCustomer);

    void deleteCustomer(Long id);

    Customer findByEmail(String email);
}