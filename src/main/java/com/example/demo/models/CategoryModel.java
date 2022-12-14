package com.example.demo.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryModel {

    @NotNull(message="Name Arabic in Category may not be null")
    private String nameAr;

    @NotNull(message="Name English in Category  may not be null")
    private String nameEn;
}
