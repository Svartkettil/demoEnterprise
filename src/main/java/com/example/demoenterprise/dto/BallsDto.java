package com.example.demoenterprise.dto;

import com.example.demoenterprise.entity.BallsEntity;

import java.math.BigDecimal;

public class BallsDto {
    private Long id;
    String name;
    String category;
    BigDecimal price;

    public BallsDto(){
    }

    public BallsDto(BallsEntity balls) {
        this.id = balls.getId();
        this.name = balls.getName();
        this.category = balls.getCategory();
        this.price = balls.getPrice();
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
