package com.example.demo.entity;

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
    private Order order;

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "Product_ID",referencedColumnName="ID")
    private Product product;


}
