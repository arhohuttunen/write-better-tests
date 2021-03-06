package com.arhohuttunen.relevancy;

import com.arhohuttunen.model.Person;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class IrrelevantInformation {
    @Test
    void newPersonIsUnverified() {
        // Are any of these arguments important here?
        Person person = new Person("John", "Doe", 15);

        assertEquals(Person.Status.UNVERIFIED, person.getStatus());
    }

    @Test
    void personIsMinor() {
        // Is the name of the person important here?
        Person person = new Person("John", "Doe", 15);

        assertTrue(person.isMinor());
    }

    @Test
    void returnFullNameOfUser() {
        // Is the age of the person important here?
        Person person = new Person("John", "Doe", 15);

        assertEquals("John Doe", person.getFullName());
    }
}
