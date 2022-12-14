package com.example.demo.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
public class ProductModel {

    private Long id;

    @NotNull(message="Name Arabic of Product may not be null")
    private String nameAr;

    @NotNull(message="Name English of Product may not be null")
    private String nameEn;

    @NotNull(message="Price may not be null")
    private Long price;

    @Min(value = 10,message = "Quantity must be greater than 10 ")
    private Long quantity;

    @JsonIgnore
    private int numberOfProductsPurchased;

    @NotNull(message="Image may not be null")
    private String image;
}
