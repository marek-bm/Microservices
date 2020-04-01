package com.mj.rental.profileservice.controller;

import com.mj.rental.profileservice.service.CustomerService;
import model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/services")
public class ProfileController {

    @Autowired
    CustomerService customerService;

    @PostMapping("/profile")
    public Customer save(@RequestBody Customer customer){
        return customerService.save(customer);
    }

    @GetMapping ("/profiles")
    public List<Customer> findAll(){
        return customerService.findAll();
    }

    @GetMapping ("/profile")
    public ResponseEntity<Customer> findOne(@RequestParam int id){
        Optional<Customer> optionalCustomer= customerService.findById(id);
        if(!optionalCustomer.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } else {
            return ResponseEntity.ok(optionalCustomer.get());
        }
    }
}
