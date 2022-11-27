package com.example.demo.service;

import com.example.demo.entity.Category;
import com.example.demo.models.ProductModel;

import java.util.List;

public interface CategoryInterface {

    public void createCategory(Category category);

    public List<Category> displayAllCategories();

    public Category displayCategoryById(Long id);

    public void addProduct(Long id ,  ProductModel productModel);
}
