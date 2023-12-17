package service;

import java.util.ArrayList;
import java.util.List;

import entities.Product;

public class Cart {
    private List<Product> items;

    public Cart() {
        this.items = new ArrayList<>();
    }

    public void addItem(Product product) {
        items.add(product);
    }

    public void displayCart() {
        // Implement display logic
    }

    // Other methods as needed
}
