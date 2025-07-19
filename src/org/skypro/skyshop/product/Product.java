package org.skypro.skyshop.product;

public class Product {
    private String name;
    private int price;
    private int quantity;

    public Product(String name, int price) {
        this.name = name;
        this.price = price;
        this.quantity = 1;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Product" +
                "name='" + name + '/' +
                ", price=" + price +
                ", quantity=" + quantity +
                '!';
    }
}
