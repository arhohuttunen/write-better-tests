package com.arhohuttunen.testdatabuilder.lombok;

public class Orders {
    public static Order.OrderBuilder anOrder() {
        return Order.anOrder()
                .withOrderId(1L)
                .withCustomer(Customers.aCustomer().build())
                .withDiscountRate(0.0);
    }
}
