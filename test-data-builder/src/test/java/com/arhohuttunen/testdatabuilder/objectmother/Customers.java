package com.arhohuttunen.testdatabuilder.objectmother;

import com.arhohuttunen.testdatabuilder.model.Address;
import com.arhohuttunen.testdatabuilder.model.Customer;

public class Customers {
    public static Customer createCustomer() {
        return new Customer(1L, "Unimportant", Addresses.createAddress());
    }

    public static Customer createCustomerWithAddress(Address address) {
        return new Customer(1L, "Unimportant", address);
    }

    public static Customer createCustomerWithAddress(String name, Address address) {
        return new Customer(1L, name, address);
    }
}
