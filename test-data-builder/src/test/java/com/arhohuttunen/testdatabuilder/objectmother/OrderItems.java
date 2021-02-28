package com.arhohuttunen.testdatabuilder.objectmother;

import com.arhohuttunen.testdatabuilder.model.OrderItem;

public class OrderItems {
    public static OrderItem createOrderItem(String name) {
        return new OrderItem(name, 1);
    }
}
