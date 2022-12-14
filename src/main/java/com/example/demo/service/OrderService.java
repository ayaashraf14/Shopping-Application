package com.example.demo.service;

import com.example.demo.repository.entity.Customer;
import com.example.demo.repository.entity.Order;
import com.example.demo.models.OrderModel;
import com.example.demo.models.OrderDetailsModel;

import java.util.List;

public interface OrderService {

    public Order createOrder(List<OrderModel> orderModel, Customer customer);

    public List<OrderDetailsModel> getAllOrder();

    public  List<OrderDetailsModel> oderToOrderDetails(List<Order> orders);




}
