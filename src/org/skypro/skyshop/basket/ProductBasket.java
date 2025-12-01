package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.*;

public class ProductBasket {
    private final Map<String, List<Product>> productsMap = new HashMap<>();

    public void addProduct(Product product) {
        if (product == null) {
            return;
        }
        String name = product.getName();
        if (productsMap.containsKey(name)) {
            productsMap.get(name).add(product);
        } else {
            List<Product> list = new ArrayList<>();
            list.add(product);
            productsMap.put(name, list);
        }
    }

    public int getTotalCost() {
        return productsMap.values().stream()
                .flatMap(Collection::stream)
                .mapToInt(Product::getPrice)
                .sum();
    }

    public boolean containsProduct(String name) {
        return productsMap.containsKey(name);
    }

    public void printBasket() {
        if (productsMap.isEmpty()) {
            System.out.println("Корзина пуста");
            return;
        }

        int totalPrice = productsMap.values().stream()
                .flatMap(Collection::stream)
                .mapToInt(Product::getPrice)
                .sum();

        long specialCount = productsMap.values().stream()
                .flatMap(Collection::stream)
                .filter(Product::isSpecial)
                .count();

        productsMap.values().stream()
                .flatMap(Collection::stream)
                .forEach(System.out::println);

        System.out.println("Итого: " + totalPrice);
        System.out.println("Специальных товаров: " + specialCount);
    }
        public List<Product> getProductsByName(String name) {
            return productsMap.getOrDefault(name, new ArrayList<>());
        }

        public List<Product> removeProductsByName(String name) {
            return productsMap.remove(name);
        }
    }