package com.example.demo.repository.entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import lombok.Data;
import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "PRODUCT")
public class Product {
    @Id
    @SequenceGenerator(name = "PRODUCT_SEQ", sequenceName = "PRODUCT_SEQ", allocationSize =1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PRODUCT_SEQ")
    @Column
    private Long id;

    @Column(name = "NAME_AR")
    private String nameAr;

    @Column(name = "NAME_EN")
    private String nameEn;


    private Long price;

    private Long quantity;

    @Column
    @NotNull
    private int numberOfProductsPurchased;

    private String image;

    @OneToMany(mappedBy = "product")
    @JsonIgnore
    private List<OrderProduct> orderProducts;


    @ManyToOne
    @JoinColumn(name = "category_id",referencedColumnName="ID")
    private Category category;

    public Product() {

    }
}

