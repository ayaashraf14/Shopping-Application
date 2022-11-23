package com.example.demo.service;

import com.example.demo.entity.Order;
import com.example.demo.models.OrderModel;

import java.util.List;

public interface OrderInterface {

    public Order createOrder(List< OrderModel> orderModel);

    public List<Order> getAllOrder();


}
