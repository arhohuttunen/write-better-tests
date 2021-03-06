package com.arhohuttunen.model;

import com.arhohuttunen.model.Person;

public class Persons {
    public static Person createPerson() {
        return new Person("John", "Doe", 15);
    }
}
