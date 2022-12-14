package com.example.demo.mapper;

import com.example.demo.models.CategoryModel;
import com.example.demo.repository.entity.Category;
import org.mapstruct.Mapper;

@Mapper
public interface CategoryMapper {

    public Category ModelToCategory(CategoryModel categoryModel);
}
