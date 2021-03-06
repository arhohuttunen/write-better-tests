package com.arhohuttunen.structure;

import java.util.HashMap;
import java.util.Map;

public class Store {
    private final Map<Long, Integer> inventory = new HashMap<>();

    public void addInventory(Product product, int quantity) {
        Integer count = getInventory(product) + quantity;
        inventory.put(product.getId(), count);
    }

    public boolean removeInventory(Product product, int quantity) {
        int count = getInventory(product) - quantity;
        if (count < 0) {
            return false;
        }
        inventory.put(product.getId(), count);
        return true;
    }

    public int getInventory(Product product) {
        return inventory.getOrDefault(product.getId(), 0);
    }
}
