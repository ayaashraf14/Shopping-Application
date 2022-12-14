package com.example.demo.controller;

import com.example.demo.repository.entity.Order;
import com.example.demo.models.OrderModel;
import com.example.demo.models.OrderDetailsModel;
import com.example.demo.service.CustomerService;
import com.example.demo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/order")
@Validated
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private CustomerService customerService;

    @GetMapping
    public List<OrderDetailsModel> getOrders(){
        return orderService.getAllOrder();
    }

    @PostMapping("/{id}")
    public Order createOrder(@Valid @RequestBody List<OrderModel> orderModel, @PathVariable Long id){
        return customerService.addOrder(orderModel,id);
    }

    @GetMapping("/{id}")
    public List<OrderDetailsModel> getOrders(@PathVariable Long id){
        return customerService.getOrders(id);
    }

}
