package com.arhohuttunen.testdatabuilder.lombok;

public class Customers {
    public static Customer.CustomerBuilder aCustomer() {
        return Customer.aCustomer()
                .withCustomerId(1L)
                .withName("Unimportant")
                .withAddress(Addresses.anAddress().build());
    }
}
