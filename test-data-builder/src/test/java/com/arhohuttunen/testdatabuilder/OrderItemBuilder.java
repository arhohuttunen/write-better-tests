package com.arhohuttunen.testdatabuilder;

public class OrderItemBuilder {
    private String name = "Unimportant";
    private Integer quantity = 1;

    public static OrderItemBuilder anOrderItem() {
        return new OrderItemBuilder();
    }

    public OrderItemBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public OrderItemBuilder withQuantity(Integer quantity) {
        this.quantity = quantity;
        return this;
    }

    public OrderItem build() {
        return new OrderItem(name, quantity);
    }
}
