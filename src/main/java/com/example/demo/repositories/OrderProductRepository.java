package com.example.demo.repositories;

import com.example.demo.entity.OrderProduct;
import com.example.demo.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface OrderProductRepository extends JpaRepository<OrderProduct, Long> {

    @Query("SELECT p FROM Product  p LEFT JOIN OrderProduct op ON p.id= op.product.id WHERE op.order.id=:id")
    public List<Product>getProductByorderID(@Param(("id")) Long id);


}
