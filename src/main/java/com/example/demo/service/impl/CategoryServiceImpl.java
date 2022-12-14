package com.example.demo.service.impl;

import com.example.demo.mapper.CategoryMapper;
import com.example.demo.models.CategoryModel;
import com.example.demo.repository.entity.Category;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.service.ProductService;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements com.example.demo.service.CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private ProductService productService;


    private CategoryMapper categoryMapper= Mappers.getMapper(CategoryMapper.class);

    @Override
    public void createCategory(CategoryModel categoryModel) {
        Category category=categoryMapper.ModelToCategory(categoryModel);
        System.out.println(category);
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


}
