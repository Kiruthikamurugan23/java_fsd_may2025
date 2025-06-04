package com.backend.fastx.controller;


import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.backend.fastx.model.Customer;
import com.backend.fastx.service.CustomerService;

@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService; // variable name should follow camelCase

    @PostMapping("/api/add/customer") // added leading slash (good practice)
    public Customer insertCustomer(@RequestBody Customer customer) {
        return customerService.insertCustomer(customer);
    }
    @GetMapping("/api/get/allcustomer")
    public ResponseEntity<?> getCustomer() {
        return ResponseEntity.status(HttpStatus.OK).body(customerService.getAll());
    }
    @GetMapping("/api/customer/get-one")
    public Customer getCustomerById(Principal principal) {
        System.out.println("Username from token: " + principal.getName()); // ✅ Add this line
        String username = principal.getName(); 
        return customerService.getCustomerByUsername(username);
    }

    @PutMapping("/api/update/customer/{id}")
    public ResponseEntity<?> updateCustomer(@PathVariable int id, 
                                            @RequestBody Customer updatedCustomer,
                                            Principal principal) {
        System.out.println("User from token: " + principal.getName());
        Customer customer = customerService.updateCustomer(id, updatedCustomer);
        return ResponseEntity.ok(customer);
    }



    @DeleteMapping("/api/delete/customer/{id}")
    public ResponseEntity<?> deleteCustomer(@PathVariable int id) {
        customerService.deleteCustomer(id);
        return ResponseEntity.ok("Customer deleted successfully with id: " + id);
    }
    
    @GetMapping("/api/get/customer/byname/{name}")
    public ResponseEntity<?> getCustomerByName(@PathVariable String name) {
        Customer customer = customerService.getCustomerByName(name);
        return ResponseEntity.ok(customer);
    }


    
}


