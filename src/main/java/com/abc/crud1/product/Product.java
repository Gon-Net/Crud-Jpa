package com.abc.crud1.product;


import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.Period;

@Entity
@Table
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String name;
    private float price;
    private LocalDate localDate;
    @Transient
    private int antiquity;

    public Product() {
    }

    public Product(Long id, String name, float price, LocalDate localDate) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.localDate = localDate;
    }

    public Product(String name, float price, LocalDate localDate) {
        this.name = name;
        this.price = price;
        this.localDate = localDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public LocalDate getLocalDate() {
        return localDate;
    }

    public void setLocalDate(LocalDate localDate) {
        this.localDate = localDate;
    }

    public int getAntiquity() {
        return Period.between(this.localDate, localDate.now()).getYears();
    }

    public void setAntiquity(int antiquity) {
        this.antiquity = antiquity;
    }
}
