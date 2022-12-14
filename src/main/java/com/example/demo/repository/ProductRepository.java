package com.example.demo.repository;

import com.example.demo.repository.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query("SELECT p FROM Product p ORDER BY p.numberOfProductsPurchased DESC")
    public List<Product> allProductsOrderedByPopularity();


}
