package com.backend.fastx.service;



import java.util.List;

import org.springframework.stereotype.Service;

import com.backend.fastx.model.Customer;
import com.backend.fastx.model.User;
import com.backend.fastx.repository.CustomerRepository;



@Service
public class CustomerService {
	private CustomerRepository customerRepository;
	private UserService userService; 
	
	public CustomerService(CustomerRepository customerRepository, UserService userService) {
		
		this.customerRepository = customerRepository;
		this.userService = userService;
	}

	public Customer insertCustomer(Customer customer) {
	    // Extract user from the customer object
	    User user = customer.getUser();

	    // Assign CUSTOMER role to the user
	    user.setRole("CUSTOMER");

	    // Register (save) user in the database
	    user = userService.signUp(user);

	    // Attach the persisted user back to the customer
	    customer.setUser(user);

	    // Save and return the customer
	    return customerRepository.save(customer);
	}


	public List<Customer>getAll() {
		return customerRepository.findAll();
	}
	


	public Customer updateCustomer(int id, Customer updatedCustomer) {
	    Customer dbCustomer = customerRepository.findById(id)
	        .orElseThrow(() -> new RuntimeException("Customer not found with ID: " + id));

	    if (updatedCustomer.getName() != null)
	        dbCustomer.setName(updatedCustomer.getName());
	    if (updatedCustomer.getEmail() != null)
	        dbCustomer.setEmail(updatedCustomer.getEmail());
	    if (updatedCustomer.getGender() != null)
	        dbCustomer.setGender(updatedCustomer.getGender());
	    if (updatedCustomer.getContact() != null)
	        dbCustomer.setContact(updatedCustomer.getContact());
	    if (updatedCustomer.getAddress() != null)
	        dbCustomer.setAddress(updatedCustomer.getAddress());

	    return customerRepository.save(dbCustomer);
	}
	public void deleteCustomer(int id) {
	    if (!customerRepository.existsById(id)) {
	        throw new RuntimeException("Customer not found with id: " + id);
	    }
	    customerRepository.deleteById(id);
	}

	public Customer getCustomerByName(String name) {
	    Customer customer = customerRepository.getCustomerByName(name);
	    if (customer == null) {
	        throw new RuntimeException("Customer not found with name: " + name);
	    }
	    return customer;
	}
	public Customer getCustomerByUsername(String username) {
	    System.out.println("Fetching customer for username: " + username); 
	    Customer customer = customerRepository.getCustomerByUserName(username);
	    System.out.println("Customer found: " + customer); 
	    return customer;
	}
}

	


 
	

