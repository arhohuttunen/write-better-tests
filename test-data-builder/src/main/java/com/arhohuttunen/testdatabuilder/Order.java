package com.arhohuttunen.testdatabuilder;

import java.util.List;

public class Order {
    private final Long orderId;
    private final Customer customer;
    private final List<OrderItem> orderItems;
    private final Double discountRate;
    private final String couponCode;

    public Order(Long orderId, Customer customer, List<OrderItem> orderItems, Double discountRate, String couponCode) {
        this.orderId = orderId;
        this.customer = customer;
        this.orderItems = orderItems;
        this.discountRate = discountRate;
        this.couponCode = couponCode;
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
