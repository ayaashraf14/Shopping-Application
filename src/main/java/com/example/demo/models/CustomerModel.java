package com.example.demo.models;


import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;

@Data
public class CustomerModel {

    @NotNull(message="UserName may not be null")
    private String userName;

    @NotNull(message="Password may not be null")
    private String password;

    @NotNull(message="Name may not be null")
    private String name;

    private Long age;
}