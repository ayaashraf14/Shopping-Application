package com.example.demo.controller;

import com.example.demo.models.CustomerModel;
import com.example.demo.repository.entity.Customer;
import com.example.demo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/customer")
@Validated
public class CustomerController {

    @Autowired
    private CustomerService customerService;


    @PostMapping
    public Customer createCustomer(@Valid @RequestBody CustomerModel customerModel){
        return  customerService.create(customerModel);
    }




}
