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

    default boolean matches(String query) {
        if (query == null) {
            return false;
        }
        String lowerQuery = query.toLowerCase();
        String representation = getStringRepresentation().toLowerCase();
        return representation.contains(lowerQuery);
    }
}
