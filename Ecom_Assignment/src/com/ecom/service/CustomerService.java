package com.ecom.service;

import com.ecom.dao.CustomerDao;
import com.ecom.dao.impl.CustomerDaoImpl;
import com.ecom.model.Customer;

import java.util.List;

public class CustomerService {

    private CustomerDao customerDao = new CustomerDaoImpl();
    public void insertCustomer(Customer customer) {
        customerDao.insertCustomer(customer);
    }

    public List<Customer> getAll() {
        return customerDao.getAllCustomer();
    }
}
