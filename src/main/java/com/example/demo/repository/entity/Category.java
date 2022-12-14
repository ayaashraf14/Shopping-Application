package com.example.demo.repository.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Category {
    @Id
    @SequenceGenerator(name = "CATEGORY_SEQ", sequenceName = "CATEGORY_SEQ", allocationSize =1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CATEGORY_SEQ")
    @Column
    private Long id;

    @Column
    private String nameAr;

    @Column
    private String nameEn;

    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL,mappedBy = "category")
    @JsonIgnore
    private List<Product> products;



}
