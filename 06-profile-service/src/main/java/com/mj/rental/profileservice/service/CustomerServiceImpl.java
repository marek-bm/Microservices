package com.mj.rental.profileservice.service;

import com.mj.rental.profileservice.repository.CustomerRepository;
import model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    @Override
    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override ()
    public Optional<Customer> findById(int id) {
        Optional<Customer> optionalCustomer=customerRepository.findById(id);
        return optionalCustomer;
    }
}
