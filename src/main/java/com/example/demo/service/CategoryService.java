package com.example.demo.service;

import com.example.demo.entity.Category;
import com.example.demo.entity.Product;
import com.example.demo.models.ProductModel;
import com.example.demo.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService implements CategoryInterface{

    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private ProductInterface productInterface;

    @Override
    public void createCategory(Category category) {
        category.getProducts().forEach(product->product.setCategory(category));
        categoryRepository.save(category);
    }

    @Override
    public List<Category> displayAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Category displayCategoryById(Long id) {
        return categoryRepository.findById(id).get();
    }

    @Override
    public void addProduct(Long id, ProductModel productModel) {
        Product product =productInterface.convertToEntity(productModel);
        product.setCategory(categoryRepository.findById(id).get());
        productInterface.addProduct(product);
    }
}
