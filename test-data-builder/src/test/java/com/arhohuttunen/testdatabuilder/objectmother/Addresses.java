package com.arhohuttunen.testdatabuilder.objectmother;

import com.arhohuttunen.testdatabuilder.model.Address;

public class Addresses {
    public static Address createAddress() {
        return new Address("Some street", "Some city", "Some postal code", "Some country");
    }

    public static Address createAddress(String street, String city, String postalCode) {
        return new Address(street, city, postalCode, "Some country");
    }
}
