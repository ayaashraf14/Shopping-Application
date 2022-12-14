package com.example.demo.mapper;


import com.example.demo.models.OrderDetailsModel;
import com.example.demo.repository.entity.Order;
import org.mapstruct.Mapper;

@Mapper
public interface OrderMapper {

    public OrderDetailsModel orderToOrderDetails(Order order);
}
