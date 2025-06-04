package com.backend.fastx.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.backend.fastx.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    @Query("select c from Customer c where c.name=?1")
	Customer getCustomerByName(String name);
    
    @Query("select c from Customer c where c.user.username=?1")
    Customer getCustomerByUserName(String username);

    

}



