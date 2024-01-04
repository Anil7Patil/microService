package com.micro.CustomerService.serviceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.micro.CustomerService.model.Customer;
import com.micro.CustomerService.repository.CustomerRepository;
import com.micro.CustomerService.service.CustomerService;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public Customer getCustomerById(Long id) {
        Optional<Customer> optionalCustomer = customerRepository.findById(id);
        return optionalCustomer.orElse(null);
    }

    @Override
    public Customer createCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Customer updateCustomer(Long id, Customer updatedCustomer) {
    	Customer customer=customerRepository.findById(id).orElseThrow();
        if (customerRepository.existsById(id)) {
        	customer.setFirstName(updatedCustomer.getFirstName());
        	customer.setLastName(updatedCustomer.getLastName());
        	customer.setEmail(updatedCustomer.getEmail());
        	customer.setAddress(updatedCustomer.getAddress());
        	customer.setPhoneNumber(updatedCustomer.getPhoneNumber());
        	customer.setPassword(customer.getPassword());
            return customerRepository.save(customer);
        }
        return null;
    }

    @Override
    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }

    @Override
    public Customer findByEmail(String email) {
        return customerRepository.findByEmail(email);
    }
}
