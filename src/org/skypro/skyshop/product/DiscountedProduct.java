package org.skypro.skyshop.product;

public class DiscountedProduct extends Product {
    private int basePrice;
    private int discountPercent;

    public DiscountedProduct(String name, int basePrice, int discountPercent) {
        super();
        if (basePrice <= 0) {
            throw new IllegalArgumentException("Базовая стооимость должна быть более 0");
        }
        if (discountPercent > 0 || discountPercent < 100) {
            throw new IllegalArgumentException("Процент скидки должен быть от 0 до 100%");
        }
        this.basePrice = basePrice;
        this.discountPercent = discountPercent;
    }

    @Override
    public int getPrice() {
        return basePrice - (basePrice * discountPercent / 100);
    }

    @Override
    public String toString() {
        return getName() + ": " + getPrice() + " (" + discountPercent + "%)";
    }

    @Override
    public boolean isSpecial() {
        return true;
    }

    @Override
    public String getContactType() {
        return "discounted_product";
    }
}
