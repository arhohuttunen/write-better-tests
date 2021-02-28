package com.arhohuttunen.testdatabuilder.lombok;

import lombok.Builder;
import lombok.Data;

@Data
@Builder(builderMethodName = "aCustomer", setterPrefix = "with")
public class Customer {
    private final Long customerId;
    private final String name;
    private final Address address;
}
