package com.example.demo.service.impl;

import com.example.demo.mapper.CustomerMapper;
import com.example.demo.repository.entity.Customer;
import com.example.demo.repository.entity.Order;
import com.example.demo.models.CustomerModel;
import com.example.demo.models.OrderModel;
import com.example.demo.models.OrderDetailsModel;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.service.OrderService;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements com.example.demo.service.CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private OrderService orderService;

    private CustomerMapper customerMapper= Mappers.getMapper(CustomerMapper.class);
    @Override
    public Customer create(CustomerModel customerModel) {
        Customer customer = customerMapper.modelToCustomer(customerModel);
        return customerRepository.save(customer);
    }

    @Override
    public Order addOrder(List<OrderModel> orderModel, Long id) {
        Customer customer = customerRepository.findById(id).get();
        return orderService.createOrder(orderModel,customer);
    }

    @Override
    public List<OrderDetailsModel> getOrders(Long id) {
        Customer customer=customerRepository.findById(id).get();
        List<Order> orders =customer.getOrders();
        return orderService.oderToOrderDetails(orders);
    }


}
