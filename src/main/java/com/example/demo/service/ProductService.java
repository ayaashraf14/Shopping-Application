package com.example.demo.service;

import com.example.demo.entity.Product;
import com.example.demo.models.ProductModel;
import com.example.demo.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements ProductInterface {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryInterface categoryInterface;

    @Override
    public List<Product> getAllProduct() {
        return productRepository.findAll();
    }

    @Override
    public Product addProduct(Product product) {
        productRepository.save(product);
        return product;
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

    public Product convertToEntity(ProductModel productModel){
        Product product = new Product();
        product.setNameAr(productModel.getNameAr());
        product.setNameEn(productModel.getNameEn());
        product.setPrice(productModel.getPrice());
        product.setQuantity(productModel.getQuantity());
        product.setImage(productModel.getImage());
        product.setNumberOfProductsPurchased(0);
        return product;
    }

    @Override
    public List<Product> allProductsOrderedByPopularity() {
        return productRepository.allProductsOrderedByPopularity();
    }

}
