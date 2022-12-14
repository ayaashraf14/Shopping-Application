package com.example.demo.controller;

import com.example.demo.models.CategoryModel;
import com.example.demo.repository.entity.Category;
import com.example.demo.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/category")
@Validated
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping
    public void createCategory(@Valid @RequestBody CategoryModel categoryModel){
        categoryService.createCategory(categoryModel);
    }

    @GetMapping
    public List<Category> displayCategories(){
        return categoryService.displayAllCategories();
    }

    @GetMapping("/{id}")
    public Category displayCategoryById(@PathVariable Long id){
        return categoryService.displayCategoryById(id);
    }

}
