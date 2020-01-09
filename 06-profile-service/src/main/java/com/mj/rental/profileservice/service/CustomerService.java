package com.mj.rental.profileservice.service;

import model.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerService {
    Customer save(Customer customer);
    List<Customer> findAll();
    Optional<Customer> findById(int id);

}
