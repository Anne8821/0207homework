package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ProductBasket {
    private final List<Product> products = new ArrayList<>();

    public void addProduct(Product product) {
        if (product != null) {
            products.add(product);
        } else {
            System.out.println("Невозможно добавить null продукт");
        }
    }

    public int getTotalCost() {
        int total = 0;
        for (Product p : products) {
            if (p != null) total += p.getPrice();
        }
        return total;
    }

    public boolean containsProduct(String name) {
        for (Product p : products) {
            if (p != null && p.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    public void printBasket() {
        if (products.isEmpty()) {
            System.out.println("Корзина пуста");
            return;
        }
        int totalPrice = 0;
        int specialCount = 0;
        for (Product p : products) {
            System.out.println(p);
            totalPrice += p.getPrice();
            if (p.isSpecial()) {
                specialCount++;
            }
        }
        System.out.println("Итого: " + totalPrice);
        System.out.println("Специальных товаров: " + specialCount);
    }

    public void clear() {
        products.clear();
    }

    public List<Product> removeProductsByName(String name) {
        List<Product> removed = new ArrayList<>();
        Iterator<Product> iterator = products.iterator();
        while (iterator.hasNext()) {
            Product p = iterator.next();
            if (p != null && p.getName().equals(name)) {
                removed.add(p);
                iterator.remove();
            }
        }
        return removed;
    }
}