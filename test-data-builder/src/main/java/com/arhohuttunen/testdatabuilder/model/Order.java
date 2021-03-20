package com.arhohuttunen.testdatabuilder.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Order {
    private final Long orderId;
    private final Customer customer;
    private final List<OrderItem> orderItems = new ArrayList<>();
    private final Double discountRate;
    private final String couponCode;

    public Order(Long orderId, Customer customer, Double discountRate, String couponCode) {
        this.orderId = Objects.requireNonNull(orderId);
        this.customer = Objects.requireNonNull(customer);
        this.discountRate = discountRate;
        this.couponCode = couponCode;
    }

    public void addOrderItem(OrderItem orderItem) {
        orderItems.add(orderItem);
    }

    public Long getOrderId() {
        return orderId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public Double getDiscountRate() {
        return discountRate;
    }

    public String getCouponCode() {
        return couponCode;
    }
}
