package com.arhohuttunen.testdatabuilder.builder;

import com.arhohuttunen.testdatabuilder.model.Order;
import com.arhohuttunen.testdatabuilder.model.OrderItem;

import java.util.ArrayList;
import java.util.List;

import static com.arhohuttunen.testdatabuilder.builder.CustomerBuilder.aCustomer;

public class OrderBuilder {
    private Long orderId = 1L;
    private CustomerBuilder customerBuilder = aCustomer();
    private List<OrderItem> orderItems = new ArrayList<>();
    private Double discountRate = 0.0;
    private String couponCode;

    private OrderBuilder() {

    }

    private OrderBuilder(OrderBuilder copy) {
        this.orderId = copy.orderId;
        this.customerBuilder = copy.customerBuilder;
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

    public OrderBuilder but() {
        return new OrderBuilder(this);
    }

    public OrderBuilder with(CustomerBuilder customerBuilder) {
        this.customerBuilder = customerBuilder;
        return this;
    }

    public OrderBuilder with(OrderItemBuilder orderItemBuilder) {
        this.orderItems.add(orderItemBuilder.build());
        return this;
    }

    public OrderBuilder withDiscountRate(Double discountRate) {
        this.discountRate = discountRate;
        return this;
    }

    public OrderBuilder withCouponCode(String couponCode) {
        this.couponCode = couponCode;
        return this;
    }

    public Order build() {
        Order order = new Order(orderId, customerBuilder.build(), discountRate, couponCode);
        orderItems.forEach(order::addOrderItem);
        return order;
    }
}
