package com.example.demo.repository.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "ORDER_PRODUCT")
public class OrderProduct {
    @Id
    @SequenceGenerator(name = "ORDER_PRODUCT_SEQ", sequenceName = "ORDER_PRODUCT_SEQ", allocationSize =1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ORDER_PRODUCT_SEQ")
    @Column
    private Long id;

    @Column
    private int quantity;

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "Order_ID",referencedColumnName="ID")
    @JsonIgnore
    private Order order;

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "Product_ID",referencedColumnName="ID")
    @JsonIgnore
    private Product product;


}
