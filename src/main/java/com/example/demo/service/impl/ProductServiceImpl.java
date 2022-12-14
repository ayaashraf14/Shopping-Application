package com.example.demo.service.impl;

import com.example.demo.mapper.ProductMapper;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.repository.entity.Category;
import com.example.demo.repository.entity.Product;
import com.example.demo.models.ProductModel;
import com.example.demo.repository.ProductRepository;
import com.example.demo.service.CategoryService;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements com.example.demo.service.ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryService categoryService;
    private ProductMapper productMapper= Mappers.getMapper(ProductMapper.class);

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Product> getAllProduct() {
        return productRepository.findAll();
    }

    @Override
    public void addProduct(Long id, ProductModel productModel) {
        Category category=categoryRepository.findById(id).get();
        Product product=productMapper.ModelToProduct(productModel);
        product.setCategory(category);
        productRepository.save(product);
    }

    @Override
    public Product updateProduct(Product product) {
        productRepository.save(product);
        return product;
    }

    @Override
    public Product findById(Long id) {
        return productRepository.findById(id).get();
    }

    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public void updateNumberOfProductsPurchased(Long id, int number) {
        //productRepository.updateNumberOfProductsPurchased(id,number);
    }



    @Override
    public List<Product> allProductsOrderedByPopularity() {
        return productRepository.allProductsOrderedByPopularity();
    }

}
