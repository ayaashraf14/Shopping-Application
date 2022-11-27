package com.example.demo.service;

import com.example.demo.entity.Customer;
import com.example.demo.entity.Order;
import com.example.demo.entity.OrderProduct;
import com.example.demo.entity.Product;
import com.example.demo.errors.ResourceNotFoundException;
import com.example.demo.models.GetOrderModel;
import com.example.demo.models.OrderDetailsModel;
import com.example.demo.models.ProductModel;
import com.example.demo.repositories.OrderProductRepository;
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

    @Autowired
    private OrderProductRepository orderProductRepository;

    @Override
    public Order createOrder(List<GetOrderModel> getOrderModel, Customer customer) {
        return orderRepository.save(mapperenitity(getOrderModel, customer));

    }

    @Override
    public List<OrderDetailsModel> getAllOrder() {

        List<Order> orders =orderRepository.findAll();
        return convertToOrderDetails(orders);
    }

    public  List<OrderDetailsModel> convertToOrderDetails( List<Order> orders){
        List<OrderDetailsModel> orderDetailsModels =new ArrayList<>();
        orders.forEach(o->{
            OrderDetailsModel orderDetailsModel =new OrderDetailsModel();
            orderDetailsModel.setId(o.getId());
            orderDetailsModel.setTotalPrice(o.getTotalPrice());
            List<Product> products=orderProductRepository.getProductByorderID(o.getId());
            orderDetailsModel.setProductModels(covertToProductModel(o.getId(),products));
            orderDetailsModels.add(orderDetailsModel);
        });
        return orderDetailsModels;
    }

    public List<ProductModel> covertToProductModel(Long orderID,List<Product> productList){
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
    public Order mapperenitity(List<GetOrderModel> getOrderModel, Customer customer){
        Order order =new Order();

        List<OrderProduct> orderProducts=new ArrayList<>();
        getOrderModel.forEach(o-> {
            OrderProduct orderProduct =new OrderProduct();
            orderProduct.setOrder(order);
            Product product= productInterface.findById(o.getId());
            if((product.getQuantity()-product.getNumberOfProductsPurchased())<o.getQuantity())
                throw new ResourceNotFoundException("test");
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
