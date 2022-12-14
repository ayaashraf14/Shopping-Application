package com.example.demo.service.impl;

import com.example.demo.mapper.OrderMapper;
import com.example.demo.repository.ProductRepository;
import com.example.demo.repository.entity.Customer;
import com.example.demo.repository.entity.Order;
import com.example.demo.repository.entity.OrderProduct;
import com.example.demo.repository.entity.Product;
import com.example.demo.exception.errors.ResourceNotFoundException;
import com.example.demo.models.OrderModel;
import com.example.demo.models.OrderDetailsModel;
import com.example.demo.models.ProductModel;
import com.example.demo.repository.OrderProductRepository;
import com.example.demo.repository.OrderRepository;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderServiceImpl implements com.example.demo.service.OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private OrderProductRepository orderProductRepository;

    private OrderMapper orderMapper= Mappers.getMapper(OrderMapper.class);

    @Override
    public Order createOrder(List<OrderModel> orderModel, Customer customer) {

        return orderRepository.save(OrderModelToOrder(orderModel, customer));

    }

    @Override
    public List<OrderDetailsModel> getAllOrder() {

        List<Order> orders =orderRepository.findAll();
        return oderToOrderDetails(orders);

    }

    public  List<OrderDetailsModel> oderToOrderDetails(List<Order> orders){
        List<OrderDetailsModel> orderDetailsModels =new ArrayList<>();
        orders.forEach(o->{
            OrderDetailsModel orderDetailsModel =new OrderDetailsModel();
            orderDetailsModel.setId(o.getId());
            orderDetailsModel.setTotalPrice(o.getTotalPrice());
            List<Product> products=orderProductRepository.getProductByorderID(o.getId());
            orderDetailsModel.setProductModels(ProductToProductModel(o.getId(),products));
            orderDetailsModels.add(orderDetailsModel);
        });
        return orderDetailsModels;
    }

    public List<ProductModel> ProductToProductModel(Long orderID, List<Product> productList){
        List<ProductModel> productModels=new ArrayList<>();
        productList.forEach(p->{
                ProductModel product=new ProductModel();
                product.setId(p.getId());
                product.setNameAr(p.getNameAr());
                product.setNameEn(p.getNameEn());
                product.setPrice(p.getPrice());
                product.setImage(p.getImage());
                product.setQuantity(orderRepository.getQuantity(orderID,product.getId()));
                productModels.add(product);
        });
        return productModels;
    }
    public Order OrderModelToOrder(List<OrderModel> getOrderModel, Customer customer){
        Order order =new Order();


        List<OrderProduct> orderProducts=new ArrayList<>();
        getOrderModel.forEach(o-> {
                    OrderProduct orderProduct =new OrderProduct();
                    orderProduct.setOrder(order);
                    System.out.println(productRepository.findById(o.getId()).isPresent());
                    Product product= productRepository.findById(o.getId()).get();
                    if((product.getQuantity()-product.getNumberOfProductsPurchased())<o.getQuantity())
                        throw new ResourceNotFoundException("Product Not Enough");
                    product.setNumberOfProductsPurchased((product.getNumberOfProductsPurchased()+o.getQuantity()));
                    orderProduct.setProduct(product);
                    System.out.println(o.getQuantity());
                    orderProduct.setQuantity(o.getQuantity());
                    orderProducts.add(orderProduct);
                }
        );
        orderProductRepository.saveAll(orderProducts);
        order.setTotalPrice(
                orderProducts
                        .stream()
                        .mapToLong(p->p.getProduct().getPrice() * p.getQuantity())
                        .sum()
        );
        order.setOrderProduct(orderProducts);
        order.setCustomer(customer);
        return order;
    }
}
