package com.qimi.goods;

public class Fruit {

    private String name;
    private String price;
    private String product;

    public Fruit(String name, String price, String product) {
        this.name = name;
        this.price = price;
        this.product = product;
    }

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }

    public String getProduct() {
        return product;
    }
}
