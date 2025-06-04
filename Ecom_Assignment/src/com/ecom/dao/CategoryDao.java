package com.ecom.dao;

import com.ecom.dao.impl.CustomerDaoImpl;
import com.ecom.exception.InvalidInputException;
import com.ecom.model.Category;
import com.ecom.model.Customer;

import java.util.List;

public interface CategoryDao {
    void insertCategory(Category category) throws InvalidInputException;
    List<Category> getAllCat();
}
