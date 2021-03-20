package com.arhohuttunen.testdatabuilder.lombok;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

@Data
@Builder(builderMethodName = "anAddress", setterPrefix = "with")
public class Address {
    @NonNull
    private final String street;
    @NonNull
    private final String city;
    @NonNull
    private final String postalCode;
    @NonNull
    private final String country;
}
