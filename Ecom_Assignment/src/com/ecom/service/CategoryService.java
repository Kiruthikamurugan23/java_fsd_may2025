
package com.ecom.service;

import com.ecom.dao.CategoryDao;
import com.ecom.dao.impl.CategoryDaoImpl;
import com.ecom.model.Category;

import java.util.List;

public class CategoryService {

    CategoryDao categoryDao = new CategoryDaoImpl();

    public List<Category> getAllCat() {
        return categoryDao.getAllCat();
    }

    public void insertCategory(Category category) {
        categoryDao.insertCategory(category);
    }
}
