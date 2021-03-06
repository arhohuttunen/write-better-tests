package com.arhohuttunen.structure;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class NoStructure {
    @Test
    void purchaseSucceedsWhenEnoughInventory() {
        Product paperclip = new Product(1L, "Paperclip");
        Store store = new Store();
        store.addInventory(paperclip, 100);
        Customer customer = new Customer();
        assertTrue(customer.purchase(store, paperclip, 10));
        assertEquals(90, store.getInventory(paperclip));
    }
}
