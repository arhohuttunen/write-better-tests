package com.arhohuttunen.testdatabuilder.lombok;

import lombok.Builder;
import lombok.Data;

@Data
@Builder(builderMethodName = "anOrderItem", setterPrefix = "with")
public class OrderItem {
    private final String name;
    private final Integer quantity;
}
