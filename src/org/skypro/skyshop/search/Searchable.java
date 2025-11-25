package org.skypro.skyshop.search;

public interface Searchable {
    String getSearchTerm();
    String getContentType();
    String getName();
    int getPrice();
    boolean isSpecial();

    default String getStringRepresentation() {
        return getName() + " - " + getContentType();
    }
}