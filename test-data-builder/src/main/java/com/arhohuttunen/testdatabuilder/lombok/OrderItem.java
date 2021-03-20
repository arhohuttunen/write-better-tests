package com.arhohuttunen.testdatabuilder.lombok;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

@Data
@Builder(builderMethodName = "anOrderItem", setterPrefix = "with")
public class OrderItem {
    @NonNull
    private final String name;
    @NonNull
    private final Integer quantity;
}
