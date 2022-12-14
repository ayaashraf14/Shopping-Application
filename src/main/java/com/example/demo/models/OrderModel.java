package com.example.demo.models;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Data
public class OrderModel {

    @NotNull(message="Product Id may not be null")
    private long id;

    @Min(value = 1,message = "Quantity must greater than 1")
    private int quantity;

}
