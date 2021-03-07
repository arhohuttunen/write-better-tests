package com.arhohuttunen.relevancy;

import com.arhohuttunen.Customer;
import com.arhohuttunen.Product;
import com.arhohuttunen.Store;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class EagerTest {
    @Test
    void purchaseProducts() {
        // Arrange
        Product paperclip = new Product("Paperclip");
        Product printerPaper = new Product("Printer paper");
        Store store = new Store();
        store.addInventory(paperclip, 100);
        store.addInventory(printerPaper, 50);
        Customer customer = new Customer();
        // Act
        boolean purchaseSucceeded = customer.purchase(store, paperclip, 10);
        // Assert
        assertTrue(purchaseSucceeded);
        assertEquals(90, store.getInventory(paperclip));
        // Act
        purchaseSucceeded = customer.purchase(store, printerPaper, 100);
        // Assert
        assertFalse(purchaseSucceeded);
        assertEquals(50, store.getInventory(printerPaper));
    }
}
