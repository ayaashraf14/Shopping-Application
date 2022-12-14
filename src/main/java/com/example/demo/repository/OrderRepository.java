package com.example.demo.repository;

import com.example.demo.repository.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    @Query("SELECT p.quantity FROM OrderProduct p where p.order.id=:orderID and  p.product.id=:productID")
    public Long getQuantity(@Param("orderID" ) Long orderID,@Param("productID" ) Long porductID );
}
