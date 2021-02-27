package com.arhohuttunen.testdatabuilder;

import java.util.ArrayList;
import java.util.List;

public class OrderBuilder {
    private Long orderId = 1L;
    private Customer customer = new CustomerBuilder().build();
    private List<OrderItem> orderItems = new ArrayList<>();
    private Double discountRate = 0.0;
    private String couponCode;

    private OrderBuilder() {

    }

    private OrderBuilder(OrderBuilder copy) {
        this.orderId = copy.orderId;
        this.customer = copy.customer;
        this.orderItems = copy.orderItems;
        this.discountRate = copy.discountRate;
        this.couponCode = copy.couponCode;
    }

    public static OrderBuilder anOrder() {
        return new OrderBuilder();
    }

    public OrderBuilder withId(Long orderId) {
        OrderBuilder builder = new OrderBuilder(this);
        builder.orderId = orderId;
        return builder;
    }

    public OrderBuilder with(CustomerBuilder customerBuilder) {
        OrderBuilder builder = new OrderBuilder(this);
        builder.customer = customerBuilder.build();
        return builder;
    }

    public OrderBuilder with(OrderItemBuilder orderItemBuilder) {
        OrderBuilder builder = new OrderBuilder(this);
        builder.orderItems.add(orderItemBuilder.build());
        return builder;
    }

    public OrderBuilder withDiscountRate(Double discountRate) {
        OrderBuilder builder = new OrderBuilder(this);
        builder.discountRate = discountRate;
        return builder;
    }

    public OrderBuilder withCouponCode(String couponCode) {
        OrderBuilder builder = new OrderBuilder(this);
        builder.couponCode = couponCode;
        return builder;
    }

    public Order build() {
        return new Order(orderId, customer, orderItems, discountRate, couponCode);
    }
}
