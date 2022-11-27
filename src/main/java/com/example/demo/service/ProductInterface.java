package com.example.demo.service;

import com.example.demo.entity.Product;
import com.example.demo.models.ProductModel;

import java.util.List;

public interface ProductInterface {

    public List<Product> getAllProduct();

    public Product addProduct(Product product);

    public Product updateProduct(Product product);

    public Product findById (Long id);

    public void deleteProduct(Long id);

    public void updateNumberOfProductsPurchased(Long id, int number);
    public Product convertToEntity(ProductModel productModel);

    public List<Product> allProductsOrderedByPopularity();




}
