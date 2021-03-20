package com.arhohuttunen.testdatabuilder.model;

import java.util.Objects;

public class Customer {
    private final Long customerId;
    private final String name;
    private final Address address;

    public Customer(Long customerId, String name, Address address) {
        this.customerId = Objects.requireNonNull(customerId);
        this.name = Objects.requireNonNull(name);
        this.address = Objects.requireNonNull(address);
    }

    public Long getCustomerId() {
        return customerId;
    }

    public String getName() {
        return name;
    }

    public Address getAddress() {
        return address;
    }
}
