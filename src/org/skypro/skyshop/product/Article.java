package org.skypro.skyshop.product;

import org.skypro.skyshop.search.Searchable;

public record Article(String title, String text) implements Searchable {

    @Override
    public String toString() {
        return title + "." + text;
    }

    @Override
    public String getSearchTerm() {
        return title + " " + text;
    }

    @Override
    public String getContentType() {
        return "ARTICLE";
    }

    @Override
    public String getName() {
        return title;
    }

    @Override
    public int getPrice() {
        return 0;
    }

    @Override
    public boolean isSpecial() {
        return false;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Article article = (Article) object;
        return title != null ? title.equals(article.title) : article.title == null;
    }
}