package com.example.demo.mapper;

import com.example.demo.models.ProductModel;
import com.example.demo.repository.entity.Product;
import org.mapstruct.Mapper;

@Mapper
public interface ProductMapper {

    public Product ModelToProduct(ProductModel productModel);
}
