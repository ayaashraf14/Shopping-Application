package com.example.demo.controller;

import com.example.demo.entity.Order;
import com.example.demo.entity.Product;
import com.example.demo.models.OrderModel;
import com.example.demo.service.OrderInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
@Validated
public class OrderController {

    @Autowired
    private OrderInterface orderInterface;

    @GetMapping
    public List<Order> getAllOrder(){
        return orderInterface.getAllOrder();
    }

    @PostMapping
    public Order createOrder(@RequestBody List<OrderModel> orderModel){

        return orderInterface.createOrder(orderModel);
    }



}
