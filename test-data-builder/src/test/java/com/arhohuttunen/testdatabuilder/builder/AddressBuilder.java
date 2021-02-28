package com.arhohuttunen.testdatabuilder.builder;

import com.arhohuttunen.testdatabuilder.model.Address;

public class AddressBuilder {
    private String street = "Some street";
    private String city = "Some city";
    private String postalCode = "Some postal code";
    private String country = "Some country";

    private AddressBuilder() {

    }

    private AddressBuilder(AddressBuilder copy) {
        this.street = copy.street;
        this.city = copy.city;
        this.postalCode = copy.postalCode;
        this.country = copy.country;
    }

    public static AddressBuilder anAddress() {
        return new AddressBuilder();
    }

    public AddressBuilder but() {
        return new AddressBuilder(this);
    }

    public AddressBuilder withStreet(String street) {
        this.street = street;
        return this;
    }

    public AddressBuilder withCity(String city) {
        this.city = city;
        return this;
    }

    public AddressBuilder withPostalCode(String postalCode) {
        this.postalCode = postalCode;
        return this;
    }

    public AddressBuilder withCountry(String country) {
        this.country = country;
        return this;
    }

    public Address build() {
        return new Address(street, city, postalCode, country);
    }
}
