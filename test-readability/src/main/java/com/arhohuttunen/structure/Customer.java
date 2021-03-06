package com.arhohuttunen.structure;

public class Customer {
    public boolean purchase(Store store, Product product, int quantity) {
        return store.removeInventory(product, quantity);
    }
}
