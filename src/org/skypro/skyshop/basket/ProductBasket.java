package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;

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
        int total = 0;
        for (List<Product> list : productsMap.values()) {
            for (Product p : list) {
                total += p.getPrice();
            }
        }
        return total;
    }

    public boolean containsProduct(String name) {
        return productsMap.containsKey(name);
    }

    public void printBasket() {
        if (productsMap.isEmpty()) {
            System.out.println("Корзина пуста");
            return;
        }

        int totalPrice = 0;
        int specialCount = 0;

        for (Map.Entry<String, List<Product>> entry : productsMap.entrySet()) {
            for (Product p : entry.getValue()) {
                System.out.println(p);
                totalPrice += p.getPrice();
                if (p.isSpecial()) {
                    specialCount++;
                }
            }
        }

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