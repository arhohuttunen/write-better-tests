package com.arhohuttunen.testdatabuilder.lombok;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;
import lombok.Singular;

import java.util.List;

@Data
@Builder(builderMethodName = "anOrder", toBuilder = true, setterPrefix = "with")
public class Order {
    @NonNull
    private final Long orderId;
    @NonNull
    private final Customer customer;
    @Singular
    private final List<OrderItem> orderItems;
    private final Double discountRate;
    private final String couponCode;
}
