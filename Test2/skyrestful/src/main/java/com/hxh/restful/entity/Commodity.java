package com.hxh.restful.entity;

import java.io.Serializable;

public class Commodity implements Serializable {

    private String sku;
    private String name;
    private String description;
    private float price;
    private String category;
    private int amount;
    private int buy_num;
    private float price_all;

    public float getPrice_all() {
        return price_all;
    }

    public void setPrice_all(float price_all) {
        this.price_all = price_all;
    }

    public int getBuy_num() {
        return buy_num;
    }

    public void setBuy_num(int buy_num) {
        this.buy_num = buy_num;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
