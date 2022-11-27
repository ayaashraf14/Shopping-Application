package com.example.demo.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Data
public class ProductModel {

    private Long id;

    private String nameAr;

    private String nameEn;

    private Long price;

    private Long quantity;

    @JsonIgnore
    private int numberOfProductsPurchased;

    private String image;
}
