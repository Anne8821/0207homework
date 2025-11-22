package org.skypro.skyshop.product;

public class SimpleProduct extends Product {
    private final String name;
    private final int price;

    public SimpleProduct(String name, int price){
        super();
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Название продукта не может быть пустым");
        }
        if (price <= 0) {
            throw new IllegalArgumentException("Цена должна быть положительной");
        }
        this.name = name;
        this.price = price;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return getName() + ": " + getPrice();
    }

    @Override
    public boolean isSpecial() {
        return false;
    }

    @Override
    public String getContactType() {
        return "";
    }

    @Override
    public String getStringRepresentation() {
        return ("Продукт: " + name + ", Цена: " + price + " руб.");
    }
}