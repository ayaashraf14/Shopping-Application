package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "ORDER_INFO")
public class Order {

    @Id
    @SequenceGenerator(name = "ORDER_SEQ", sequenceName = "ORDER_SEQ", allocationSize =1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ORDER_SEQ")
    @Column
    private Long id;

    @Column
    private Long totalPrice;

    @OneToMany(mappedBy = "order")
    @JsonIgnore
    private List<OrderProduct> orderProduct;

    @ManyToOne
    @JoinColumn(name = "customer_id",referencedColumnName="ID")
    @JsonIgnore
    private Customer customer;

}
