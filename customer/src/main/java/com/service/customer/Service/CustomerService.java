package com.service.customer.Service;

import com.service.customer.Entity.Customer;
import com.service.customer.Repository.CustomerRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class CustomerService {
    @Autowired
    CustomerRepository customerRepository;

    public Customer addCustomer(@RequestBody Customer customer) {
        return customerRepository.save(customer);
    }

    public List<Customer> getCustomer() {
        return customerRepository.findAll();
    }

    public Customer getCustomer(int id) {
        return customerRepository.findById(id).orElseThrow(() ->
                new EntityNotFoundException("id not present"));
    }

    public Boolean exisitsCustomer(int id) {
        return customerRepository.existsById(id);
    }
}
