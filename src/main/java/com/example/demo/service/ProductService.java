package com.example.demo.service;

import com.example.demo.repository.entity.Product;
import com.example.demo.models.ProductModel;

import java.util.List;

public interface ProductService {

    public List<Product> getAllProduct();

    public void addProduct(Long id,ProductModel productModel);

    public Product updateProduct(Product product);

    public Product findById (Long id);

    public void deleteProduct(Long id);

    public void updateNumberOfProductsPurchased(Long id, int number);

    public List<Product> allProductsOrderedByPopularity();




}
