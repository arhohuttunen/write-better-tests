package com.arhohuttunen;

public class Person {
    private final String firstName;
    private final String lastName;
    private final int age;
    private Status status = Status.UNVERIFIED;

    public enum Status {
        UNVERIFIED, VERIFIED
    }

    public Person(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    public boolean isMinor() {
        return age < 18;
    }

    public Status getStatus() {
        return status;
    }
}
