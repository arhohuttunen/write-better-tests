package com.arhohuttunen;

import java.util.HashMap;
import java.util.Map;

public class Store {
    private final Map<String, Integer> inventory = new HashMap<>();

    public void addInventory(Product product, int quantity) {
        Integer count = getInventory(product) + quantity;
        inventory.put(product.getName(), count);
    }

    public boolean removeInventory(Product product, int quantity) {
        int count = getInventory(product) - quantity;
        if (count < 0) {
            return false;
        }
        inventory.put(product.getName(), count);
        return true;
    }

    public int getInventory(Product product) {
        return inventory.getOrDefault(product.getName(), 0);
    }
}
