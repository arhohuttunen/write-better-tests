package com.arhohuttunen.structure;

import com.arhohuttunen.Customer;
import com.arhohuttunen.Product;
import com.arhohuttunen.Store;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class NoStructure {
    @Test
    void purchaseSucceedsWhenEnoughInventory() {
        Product paperclip = new Product("Paperclip");
        Store store = new Store();
        store.addInventory(paperclip, 100);
        Customer customer = new Customer();
        assertTrue(customer.purchase(store, paperclip, 10));
        assertEquals(90, store.getInventory(paperclip));
    }
}
