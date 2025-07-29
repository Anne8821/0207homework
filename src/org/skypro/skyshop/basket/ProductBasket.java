package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

public class ProductBasket {
    private final Product[] products = new Product[5];

    public void addProduct(Product product) {
        boolean addendumProduct = false;
        for (int i = 0; i < products.length; i++) {
            if (products[i] == null) {
                products[i] = product;
                addendumProduct = true;
                break;
            }
        }
        if (!addendumProduct) {
            System.out.println("Невозможно добавить продукт");
        }
    }

    public int getTotalCost() {
        int total = 0;
        for (Product product : products) {
            if (product != null) {
                total += product.getPrice();
            }
        }
        return total;
    }

    public boolean containsProduct(String name) {
        for (Product product : products) {
            if (product != null && product.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    public void clear() {
        for (int i = 0; i < products.length; i++) {
            products[i] = null;
        }
    }

    public void printBasket() {
        boolean empty = true;
        for (Product product : products) {
            if (product != null) {
                System.out.println(product.getName() + " - " + product.getPrice());
                empty = false;
            }
        }
        if (empty) {
            System.out.println("Корзина пуста");
        }
    }

    public String getTotalPrice() {
        return Integer.toString(getTotalCost());
    }
}
