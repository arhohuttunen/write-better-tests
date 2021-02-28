package com.arhohuttunen.testdatabuilder.builder;

import com.arhohuttunen.testdatabuilder.model.Customer;

import static com.arhohuttunen.testdatabuilder.builder.AddressBuilder.anAddress;

public class CustomerBuilder {
    private Long customerId = 1L;
    private String name = "Unimportant";
    private AddressBuilder addressBuilder = anAddress();

    private CustomerBuilder() {

    }

    private CustomerBuilder(CustomerBuilder copy) {
        this.customerId = copy.customerId;
        this.name = copy.name;
        this.addressBuilder = copy.addressBuilder;
    }

    public static CustomerBuilder aCustomer() {
        return new CustomerBuilder();
    }

    public CustomerBuilder withCustomerId(Long customerId) {
        this.customerId = customerId;
        return this;
    }

    public CustomerBuilder but() {
        return new CustomerBuilder(this);
    }

    public CustomerBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public CustomerBuilder with(AddressBuilder addressBuilder) {
        this.addressBuilder = addressBuilder;
        return this;
    }

    public Customer build() {
        return new Customer(customerId, name, addressBuilder.build());
    }
}
