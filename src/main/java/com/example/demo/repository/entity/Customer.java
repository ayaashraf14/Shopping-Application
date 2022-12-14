package com.example.demo.repository.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Customer {
    @Id
    @SequenceGenerator(name = "CUSTOMER_SEQ", sequenceName = "CUSTOMER_SEQ", allocationSize =1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CUSTOMER_SEQ")
    @Column
    private Long id;

    @Column(unique = true)

    private String userName;

    @Column
    private String password;

    @Column
    private String name;

    @Column
    private Long age;

    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL,mappedBy = "customer")
    @JsonIgnore
    private List<Order> orders;

    public Customer() {
    }


}
