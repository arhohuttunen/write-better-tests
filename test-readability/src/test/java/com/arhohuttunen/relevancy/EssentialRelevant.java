package com.arhohuttunen.relevancy;

import com.arhohuttunen.Customer;
import com.arhohuttunen.Person;
import com.arhohuttunen.Product;
import com.arhohuttunen.Store;
import org.junit.jupiter.api.Test;

import static com.arhohuttunen.relevancy.PersonBuilder.aPerson;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
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

    @Test
    void purchaseSucceedsWhenEnoughInventory() {
        Product paperclip = new Product("Paperclip");
        Store store = new Store();
        store.addInventory(paperclip, 100);
        Customer customer = new Customer();

        boolean purchaseSucceeded = customer.purchase(store, paperclip, 10);

        assertTrue(purchaseSucceeded);
        assertEquals(90, store.getInventory(paperclip));
    }

    @Test
    void purchaseFailWhenNotEnoughInventory() {
        Product printerPaper = new Product("Printer paper");
        Store store = new Store();
        store.addInventory(printerPaper, 50);
        Customer customer = new Customer();

        boolean purchaseSucceeded = customer.purchase(store, printerPaper, 100);

        assertFalse(purchaseSucceeded);
        assertEquals(50, store.getInventory(printerPaper));
    }
}
