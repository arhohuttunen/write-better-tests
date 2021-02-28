package com.arhohuttunen.testdatabuilder.lombok;

import lombok.Builder;
import lombok.Data;

@Data
@Builder(builderMethodName = "anAddress", setterPrefix = "with")
public class Address {
    private final String street;
    private final String city;
    private final String postalCode;
    private final String country;
}
