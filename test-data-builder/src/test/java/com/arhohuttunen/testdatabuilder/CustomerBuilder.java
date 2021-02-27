package com.arhohuttunen.testdatabuilder;

public class CustomerBuilder {
    private Long customerId = 1L;
    private String name = "Unimportant";
    private Address address = new AddressBuilder().build();

    public static CustomerBuilder aCustomer() {
        return new CustomerBuilder();
    }

    public CustomerBuilder withCustomerId(Long customerId) {
        this.customerId = customerId;
        return this;
    }

    public CustomerBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public CustomerBuilder with(AddressBuilder addressBuilder) {
        this.address = addressBuilder.build();
        return this;
    }

    public Customer build() {
        return new Customer(customerId, name, address);
    }
}
