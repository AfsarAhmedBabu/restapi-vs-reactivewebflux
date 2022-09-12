package com.spring.reactiveassignment.controller;

import com.spring.reactiveassignment.model.Customer;
import com.spring.reactiveassignment.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerService service;

    @GetMapping("/")
    public List<Customer> getAllCustomers() {
        return service.getAllCustomers();
    }

    @GetMapping("/stream")
    public Flux<Customer> getAllCustomerStream() {
        return service.getAllCustomerStream();
    }

}
