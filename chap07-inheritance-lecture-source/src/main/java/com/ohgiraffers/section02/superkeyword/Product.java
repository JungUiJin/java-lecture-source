package com.ohgiraffers.section02.superkeyword;

import java.util.Date;

public class Product {

    private String code;
    private String name;
    private String brand;
    private int price;
    private Date manufactureDate;

    public Product() {
        System.out.println("product constructor");
    }

    public Product(String code, String name, String brand, int price, Date manufactureDate) {
        this.code = code;
        this.name = name;
        this.brand = brand;
        this.price = price;
        this.manufactureDate = manufactureDate;
        System.out.println("product constructor with literal");
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Date getManufactureDate() {
        return manufactureDate;
    }

    public void setManufactureDate(Date manufactureDate) {
        this.manufactureDate = manufactureDate;
    }

    public String getInformation(){
        return code + " " + name + " " + brand + " " + price + " " + manufactureDate;
    }
}
