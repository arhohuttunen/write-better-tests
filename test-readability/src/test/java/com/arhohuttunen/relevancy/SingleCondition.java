package com.arhohuttunen.relevancy;

import com.arhohuttunen.Customer;
import com.arhohuttunen.Product;
import com.arhohuttunen.Store;
import org.junit.jupiter.api.Test;

import static com.arhohuttunen.StoreBuilder.aStore;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SingleCondition {
    @Test
    void purchaseSucceedsWhenEnoughInventory() {
        Product paperclip = new Product("Paperclip");
        Store store = aStore().withInventory(paperclip, 100).build();
        Customer customer = new Customer();

        boolean purchaseSucceeded = customer.purchase(store, paperclip, 10);

        assertTrue(purchaseSucceeded);
    }

    @Test
    void inventoryIsRemovedOnPurchase() {
        Product paperclip = new Product("Paperclip");
        Store store = aStore().withInventory(paperclip, 200).build();
        Customer customer = new Customer();

        customer.purchase(store, paperclip, 30);

        assertEquals(170, store.getInventory(paperclip));
    }

    @Test
    void purchaseFailsWhenNotEnoughInventory() {
        Product printerPaper = new Product("Printer paper");
        Store store = aStore().withInventory(printerPaper, 50).build();
        Customer customer = new Customer();

        boolean purchaseSucceeded = customer.purchase(store, printerPaper, 100);

        assertFalse(purchaseSucceeded);
    }

    @Test
    void inventoryIsNotRemovedOnFailedPurchase() {
        Product printerPaper = new Product("Printer paper");
        Store store = aStore().withInventory(printerPaper, 500).build();
        Customer customer = new Customer();

        customer.purchase(store, printerPaper, 1000);

        assertEquals(500, store.getInventory(printerPaper));
    }
}
