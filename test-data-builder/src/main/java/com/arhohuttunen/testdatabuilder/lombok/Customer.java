package com.arhohuttunen.testdatabuilder.lombok;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

@Data
@Builder(builderMethodName = "aCustomer", setterPrefix = "with")
public class Customer {
    @NonNull
    private final Long customerId;
    @NonNull
    private final String name;
    @NonNull
    private final Address address;
}
