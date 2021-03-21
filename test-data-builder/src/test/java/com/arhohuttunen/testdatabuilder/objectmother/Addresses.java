package com.arhohuttunen.testdatabuilder.objectmother;

import com.arhohuttunen.testdatabuilder.model.Address;

public class Addresses {
    public static Address createAddress() {
        return new Address("Some street", "Some city", "Some postal code", "Some country");
    }

    public static Address createAddressWithCountry(String country) {
        return new Address("Some street", "Some city", "Some postal code", country);
    }
}
