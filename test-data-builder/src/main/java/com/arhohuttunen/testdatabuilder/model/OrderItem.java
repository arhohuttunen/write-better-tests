package com.arhohuttunen.testdatabuilder.model;

import java.util.Objects;

public class OrderItem {
    private final String name;
    private final Integer quantity;

    public OrderItem(String name, Integer quantity) {
        this.name = Objects.requireNonNull(name);
        this.quantity = Objects.requireNonNull(quantity);
    }

    public String getName() {
        return name;
    }

    public Integer getQuantity() {
        return quantity;
    }
}
