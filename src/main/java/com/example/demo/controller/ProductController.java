package com.example.demo.controller;

import com.example.demo.entity.Product;
import com.example.demo.service.ProductInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductInterface productInterface;

    @GetMapping
    public List<Product> getAllProduct(){
        return productInterface.getAllProduct();
    }

    @GetMapping("{id}")
    public Product getProductById(@PathVariable Long id){
        return productInterface.findById(id);
    }

    @PutMapping
    public Product updateProduct(@RequestBody Product product){
        return productInterface.updateProduct(product);
    }

    @DeleteMapping("{id}")
    public void deleteProduct(@PathVariable Long id) {
        productInterface.deleteProduct(id);
    }

    @GetMapping("/popularity")
    public List<Product>allProductsOrderedByPopularity(){
        return productInterface.allProductsOrderedByPopularity();
    }

}
