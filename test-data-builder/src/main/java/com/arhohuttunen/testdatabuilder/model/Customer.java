package com.arhohuttunen.testdatabuilder.model;

public class Customer {
    private final Long customerId;
    private final String name;
    private final Address address;

    public Customer(Long customerId, String name, Address address) {
        this.customerId = customerId;
        this.name = name;
        this.address = address;
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
