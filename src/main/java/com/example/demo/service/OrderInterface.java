package com.example.demo.service;

import com.example.demo.entity.Customer;
import com.example.demo.entity.Order;
import com.example.demo.models.GetOrderModel;
import com.example.demo.models.OrderDetailsModel;

import java.util.List;

public interface OrderInterface {

    public Order createOrder(List<GetOrderModel> getOrderModel, Customer customer);

    public List<OrderDetailsModel> getAllOrder();

    public  List<OrderDetailsModel> convertToOrderDetails( List<Order> orders);




}
