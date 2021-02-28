package com.arhohuttunen.testdatabuilder.lombok;

public class Addresses {
    public static Address.AddressBuilder anAddress() {
        return Address.anAddress()
                .withStreet("Some street")
                .withCity("Some city")
                .withPostalCode("Some postal code")
                .withCountry("Some country");
    }
}
