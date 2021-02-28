package com.arhohuttunen.testdatabuilder.model;

public class OrderItem {
    private final String name;
    private final Integer quantity;

    public OrderItem(String name, Integer quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public Integer getQuantity() {
        return quantity;
    }
}
