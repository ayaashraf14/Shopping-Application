package com.example.demo.service;

import com.example.demo.entity.Product;

import java.util.List;

public interface ProductInterface {

    public List<Product> getAllProduct();

    public void addProduct(Product product);

    public String updateProduct(Product product);

    public Product findById (Long id);

    public void deleteProduct(Long id);




}
