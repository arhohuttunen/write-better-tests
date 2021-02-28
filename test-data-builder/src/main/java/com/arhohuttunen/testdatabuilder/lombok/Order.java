package com.arhohuttunen.testdatabuilder.lombok;

import lombok.Builder;
import lombok.Data;
import lombok.Singular;

import java.util.List;

@Data
@Builder(builderMethodName = "anOrder", toBuilder = true, setterPrefix = "with")
public class Order {
    private final Long orderId;
    private final Customer customer;
    @Singular
    private final List<OrderItem> orderItems;
    private final double discountRate;
    private final String couponCode;

    public void addOrderItem(OrderItem orderItem) {
        orderItems.add(orderItem);
    }
}
