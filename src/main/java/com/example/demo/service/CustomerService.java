package com.example.demo.service;

import com.example.demo.repository.entity.Customer;
import com.example.demo.repository.entity.Order;
import com.example.demo.models.CustomerModel;
import com.example.demo.models.OrderModel;
import com.example.demo.models.OrderDetailsModel;

import java.util.List;

public interface CustomerService {

    public Customer create(CustomerModel customerModel);

    public Order addOrder(List<OrderModel> orderModel, Long id);

    public List<OrderDetailsModel> getOrders(Long id);
}
