package com.example.demo.controller;

import com.example.demo.models.OrderDetailsModel;
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
    public List<OrderDetailsModel> getAllOrders(){
        return orderInterface.getAllOrder();
    }



//    @PostMapping
//    public Order createOrder(@RequestBody List<OrderModel> orderModel){
//
//        return orderInterface.createOrder(orderModel);
//    }

}
