package com.example.demo.models;


import lombok.Data;

import java.util.List;

@Data
public class OrderDetailsModel {

    private long id;

    private Long totalPrice;

    private List<ProductModel> productModels;
}
