package com.example.demo.controller;

import com.example.demo.repository.entity.Product;
import com.example.demo.models.ProductModel;
import com.example.demo.service.CategoryService;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/product")
@Validated
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;


    @PostMapping("{id}")
    public void addProduct(@PathVariable Long id, @Valid @RequestBody ProductModel productModel){
        productService.addProduct(id,productModel);
    }


    @GetMapping
    public List<Product> getProducts(){
        return productService.getAllProduct();
    }

    @GetMapping("{id}")
    public Product getProductById(@PathVariable Long id){
        return productService.findById(id);
    }

    @PutMapping
    public Product updateProduct(@RequestBody Product product){
        return productService.updateProduct(product);
    }

    @DeleteMapping("{id}")
    public void deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
    }

    @GetMapping("/popularity")
    public List<Product> getProductsByPopularity(){
        return productService.allProductsOrderedByPopularity();
    }


}
