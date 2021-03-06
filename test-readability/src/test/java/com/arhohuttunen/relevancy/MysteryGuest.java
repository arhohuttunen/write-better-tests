package com.arhohuttunen.relevancy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MysteryGuest {
    @Test
    void newPersonIsUnverified() {
        Person person = Persons.createPerson();

        assertEquals(Person.Status.UNVERIFIED, person.getStatus());
    }

    @Test
    void personIsMinor() {
        Person person = Persons.createPerson();

        assertTrue(person.isMinor()); // Why is the person underage?
    }

    @Test
    void returnFullNameOfUser() {
        Person person = Persons.createPerson();

        assertEquals("John Doe", person.getFullName()); // Why does the person have this name?
    }
}
