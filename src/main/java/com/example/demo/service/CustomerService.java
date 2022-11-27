package com.example.demo.service;

import com.example.demo.entity.Customer;
import com.example.demo.entity.Order;
import com.example.demo.models.CustomerModel;
import com.example.demo.models.GetOrderModel;
import com.example.demo.models.OrderDetailsModel;
import com.example.demo.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService implements CustomerInterface{

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private OrderInterface orderInterface;

    @Override
    public Customer create(CustomerModel customerModel) {
        Customer customer=new Customer();
        customer.setName(customerModel.getName());
        customer.setUserName(customerModel.getUserName());
        customer.setPassword(customerModel.getPassword());
        customer.setAge(customerModel.getAge());
        return customerRepository.save(customer);
    }

    @Override
    public Order addOrder(List<GetOrderModel> getOrderModel, Long id) {
        Customer customer =customerRepository.findById(id).get();
        return orderInterface.createOrder(getOrderModel,customer);
    }

    @Override
    public List<OrderDetailsModel> getAllOrders(Long id) {
        Customer customer=customerRepository.findById(id).get();
        List<Order> orders =customer.getOrders();
        return orderInterface.convertToOrderDetails(orders);
    }
}
