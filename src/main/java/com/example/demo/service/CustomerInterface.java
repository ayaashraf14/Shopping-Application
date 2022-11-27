package com.example.demo.service;

import com.example.demo.entity.Customer;
import com.example.demo.entity.Order;
import com.example.demo.models.CustomerModel;
import com.example.demo.models.GetOrderModel;
import com.example.demo.models.OrderDetailsModel;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface CustomerInterface {

    public Customer create(CustomerModel customerModel);

    public Order addOrder(List<GetOrderModel> getOrderModel, Long id);

    public List<OrderDetailsModel> getAllOrders(Long id);
}
