package com.arhohuttunen.relevancy;

import com.arhohuttunen.model.Person;
import org.junit.jupiter.api.Test;

import static com.arhohuttunen.model.PersonBuilder.aPerson;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class EssentialRelevant {
    @Test
    void newPersonIsUnverified() {
        Person person = aPerson().build();

        assertEquals(Person.Status.UNVERIFIED, person.getStatus());
    }

    @Test
    void personIsMinor() {
        Person person = aPerson().withAge(15).build();

        assertTrue(person.isMinor());
    }

    @Test
    void returnFullNameOfUser() {
        Person person = aPerson().withFirstName("John").withLastName("Doe").build();

        assertEquals("John Doe", person.getFullName());
    }
}
