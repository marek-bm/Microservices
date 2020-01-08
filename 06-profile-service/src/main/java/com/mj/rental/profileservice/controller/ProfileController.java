package com.mj.rental.profileservice.controller;

import com.mj.rental.profileservice.service.CustomerService;
import model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/services")
public class ProfileController {

    @Autowired
    CustomerService customerService;

    @PostMapping("/profile")
    public Customer save(@RequestBody Customer customer){
        return customerService.save(customer);
    }


}
