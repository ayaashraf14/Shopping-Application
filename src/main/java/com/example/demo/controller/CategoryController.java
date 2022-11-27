package com.example.demo.controller;

import com.example.demo.entity.Category;
import com.example.demo.models.ProductModel;
import com.example.demo.service.CategoryInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryInterface categoryInterface;

    @PostMapping
    public void createCategory(@RequestBody Category category){
        categoryInterface.createCategory(category);
    }

    @GetMapping
    public List<Category> displayAllCategories(){
        return categoryInterface.displayAllCategories();
    }

    @GetMapping("/{id}")
    public Category displayCategoryById(@PathVariable Long id){
        return categoryInterface.displayCategoryById(id);
    }

    @PostMapping("/{id}")
    public void addProduct(@PathVariable Long id ,@RequestBody ProductModel productModel){
        categoryInterface.addProduct(id,productModel);
    }
}
