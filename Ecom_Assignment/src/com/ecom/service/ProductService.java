package com.ecom.service;

import com.ecom.dao.ProductDao;
import com.ecom.dao.impl.ProductDaoImpl;
import com.ecom.model.Product;

import java.util.List;

public class ProductService {

    ProductDao productDao = new ProductDaoImpl();

    public void insertProduct(Product product) {
        productDao.insertProduct(product);
    }

    public List<Product> getProdByCatId(int catId) {
        return productDao.getByCategoryId(catId);
    }
}
