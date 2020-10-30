package com.bolivar.store.entities;

import javax.persistence.*;
import java.math.BigDecimal;


public class Product {

    private int id;
    @Column
    private String name;
    @Column
    private BigDecimal price;
    @Column
    private int quantity;
    @Column
    private String description;
    @Column
    private String potho;
    @Column
    private boolean featured;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPotho() {
        return potho;
    }

    public void setPotho(String potho) {
        this.potho = potho;
    }

    public boolean isFeatured() {
        return featured;
    }

    public void setFeatured(boolean featured) {
        this.featured = featured;
    }
}
