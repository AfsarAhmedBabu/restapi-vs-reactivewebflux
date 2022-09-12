package com.spring.reactiveassignment.service;

import com.spring.reactiveassignment.dao.CustomerDao;
import com.spring.reactiveassignment.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.List;

@Service
public class CustomerService {
    @Autowired
    private CustomerDao dao;

    public List<Customer> getAllCustomers() {
        long start = System.currentTimeMillis();
        List<Customer> customers = dao.getCustomers();
        long end = System.currentTimeMillis();
        System.out.println("Time difference between execution of dao method: " + (end-start));
        return customers;
    }

    public Flux<Customer> getAllCustomerStream() {
        long start = System.currentTimeMillis();
        Flux<Customer> customers = dao.getCustomerStream();
        long end = System.currentTimeMillis();
        System.out.println("Time difference between execution of dao stream method: " + (end-start));
        return customers;
    }

}
