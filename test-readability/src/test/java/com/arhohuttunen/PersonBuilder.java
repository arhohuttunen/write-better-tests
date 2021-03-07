package com.arhohuttunen;

public class PersonBuilder {
    private String firstName;
    private String lastName;
    private int age;
    private Person.Status status = Person.Status.UNVERIFIED;

    public static PersonBuilder aPerson() {
        return new PersonBuilder();
    }

    public PersonBuilder withFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public PersonBuilder withLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public PersonBuilder withAge(int age) {
        this.age = age;
        return this;
    }

    public PersonBuilder whoIsVerified() {
        this.status = Person.Status.VERIFIED;
        return this;
    }

    public PersonBuilder withStatus(Person.Status status) {
        this.status = status;
        return this;
    }

    public Person build() {
        Person person = new Person(firstName, lastName, age);
        person.setStatus(status);
        return person;
    }
}
