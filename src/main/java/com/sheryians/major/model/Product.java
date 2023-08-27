package com.sheryians.major.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cateroy_id", referencedColumnName = "cateroy_id")
    private Category category;

    private double price;
    private double weight;
    private String description;
    private String imageName;
}
