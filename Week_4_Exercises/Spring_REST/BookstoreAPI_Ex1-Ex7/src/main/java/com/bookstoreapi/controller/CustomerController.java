package com.bookstoreapi.controller;

import com.bookstoreapi.entity.Customer;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private List<Customer> customers = new ArrayList<>();

    // POST endpoint to create a new customer using JSON request body
    @PostMapping
    public Customer createCustomer(@RequestBody Customer customer) {
        customers.add(customer);
        return customer;
    }

    // POST endpoint to create a new customer using form data
    @PostMapping("/register")
    public Customer registerCustomer(@RequestParam("id") int id,
                                     @RequestParam("name") String name,
                                     @RequestParam("email") String email,
                                     @RequestParam("password") String password) {
        Customer customer = new Customer(id, name, email, password);
        customers.add(customer);
        return customer;
    }

    // GET endpoint to retrieve all customers
    @GetMapping
    public List<Customer> getAllCustomers() {
        return customers;
    }
}
