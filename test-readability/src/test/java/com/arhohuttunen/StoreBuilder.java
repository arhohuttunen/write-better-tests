package com.arhohuttunen;

import java.util.HashMap;
import java.util.Map;

public class StoreBuilder {
    private final Map<Product, Integer> inventory = new HashMap<>();

    public static StoreBuilder aStore() {
        return new StoreBuilder();
    }

    public StoreBuilder withInventory(Product product, int quantity) {
        inventory.put(product, quantity);
        return this;
    }

    public Store build() {
        Store store = new Store();
        inventory.forEach(store::addInventory);
        return store;
    }
}
