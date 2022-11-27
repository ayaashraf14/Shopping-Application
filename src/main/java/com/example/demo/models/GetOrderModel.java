package com.example.demo.models;

import lombok.Data;

import java.util.List;

@Data
public class GetOrderModel {

    private long id;

    private int quantity;

    private Long totalPrice;

    private List<ProductModel> productModels;
}
