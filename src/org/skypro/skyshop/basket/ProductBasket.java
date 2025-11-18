package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

public class ProductBasket {
    private final Product[] products = new Product[5];

    public void addProduct(Product product) {
        boolean added = false;
        for (int i = 0; i < products.length; i++) {
            if (products[i] == null) {
                products[i] = product;
                added = true;
                break;
            }
        }
        if (!added) {
            System.out.println("Корзина полна, невозможно добавить товар: " + product.getName());
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
        int totalPrice = 0;
        int specialCount = 0;
        boolean empty = true;

        for (Product p : products) {
            if (p != null) {
                System.out.println(p.toString());
                totalPrice += p.getPrice();
                if (p.isSpecial()) {
                    specialCount++;
                }
                empty = false;
            }
        }
        if (empty) {
            System.out.println("Корзина пуста");
        } else {
            System.out.println("Итого: " + totalPrice);
            System.out.println("Специальных товаров: " + specialCount);
        }
    }

    public void clear() {
        for (int i = 0; i < products.length; i++) {
            products[i] = null;
        }
    }
}