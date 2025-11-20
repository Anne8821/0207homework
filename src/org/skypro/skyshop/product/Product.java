package org.skypro.skyshop.product;

import org.skypro.skyshop.search.Searchable;

public abstract class Product implements Searchable {
    private String name;

    public Product(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String getSearchTerm() {
        return getName();
    }

    @Override
    public String getContentType() {
        return "PRODUCT";
    }

    @Override
    public String getStringRepresentation() {
        return getName() + " - " + getContactType();
    }

    public abstract int getPrice();

    public abstract boolean isSpecial();

    public abstract String getContactType();

//    public abstract int getPrice();

//    @Override
//    public abstract String toString();

//    public abstract boolean isSpecial();
}