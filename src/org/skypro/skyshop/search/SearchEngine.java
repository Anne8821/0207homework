package org.skypro.skyshop.search;

public class SearchEngine {
    private Searchable[] items;

    public SearchEngine(int capacity) {
        this.items = new Searchable[capacity];
    }

    public void add(Searchable item) {
        for (int i = 0; i < items.length; i++) {
            if (items[i] == null) {
                items[i] = item;
                return;
            }
        }
        System.out.println("Поисковик заполнен, добавить дополнительные элементы невозможно: " + item.getName());
    }

    public Searchable[] search(String searchTerm) {
        Searchable[] results = new Searchable[5];
        int count = 0;
        for (Searchable item : items) {
            if (item != null && item.getSearchTerm().toLowerCase().contains(searchTerm.toLowerCase())) {
                results[count] = item;
                count++;
                if (count == 5) {
                    break;
                }
            }
        }
        return results;
    }
}
