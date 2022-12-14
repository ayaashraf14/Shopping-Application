package com.example.demo.service;

import com.example.demo.models.CategoryModel;
import com.example.demo.repository.entity.Category;
import com.example.demo.models.ProductModel;

import java.util.List;

public interface CategoryService {

    public void createCategory(CategoryModel categoryModel);

    public List<Category> displayAllCategories();

    public Category displayCategoryById(Long id);


}
