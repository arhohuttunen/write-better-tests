package com.arhohuttunen.testdatabuilder.objectmother;

import com.arhohuttunen.testdatabuilder.model.Customer;
import com.arhohuttunen.testdatabuilder.model.Order;

public class Orders {
    public static Order createOrderWithCustomer(Customer customer) {
        return new Order(1L, customer, 0.0, null);
    }

    public static Order createOrderWithDiscount(Double discountRate) {
        return new Order(1L, Customers.createCustomer(), discountRate, null);
    }

    public static Order createOrderWithCouponCode(String couponCode) {
        return new Order(1L, Customers.createCustomer(), 0.0, couponCode);
    }
}
