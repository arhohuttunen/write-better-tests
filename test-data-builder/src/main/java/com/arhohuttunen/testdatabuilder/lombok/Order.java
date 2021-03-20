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
    @Builder.Default
    private final Double discountRate = 0.0;
    private final String couponCode;
}
