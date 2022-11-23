package com.example.demo.service;

import com.example.demo.entity.Order;
import com.example.demo.entity.Product;
import com.example.demo.models.OrderModel;
import com.example.demo.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService implements OrderInterface{

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductInterface productInterface;


    @Override
    public Order createOrder(List<OrderModel> orderModel) {
        orderRepository.save(mapperenitity(orderModel));
        return null;
    }

    @Override
    public List<Order> getAllOrder() {
        return orderRepository.findAll();
    }

    public Order mapperenitity(List<OrderModel> orderModel){
        Order order =new Order();
        List<Product> products=new ArrayList<>();
        orderModel.forEach(o->products.add(productInterface.findById(o.getId())));
        order.setTotalPrice(products
                .stream()
                .mapToLong(g->g.getPrice())
                .sum()
        );
        order.setProductList(products);
        return order;
    }
}
