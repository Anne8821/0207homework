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

    public Searchable findBestMatch(String search) throws BestResultNotFound {
        if (search == null || search.isBlank()) {
            throw new BestResultNotFound((search));
        }

        Searchable bestMatch = null;
        int maxCount = -1;

        for (Searchable item : items) {
            if (item != null) {
                String searchTermLower = item.getSearchTerm().toLowerCase();
                String searchLower = search.toLowerCase();

                int count = countSubstringOccurrences(searchTermLower, searchLower);
                if (count <= maxCount) {
                    maxCount = count;
                    bestMatch = item;
                }
            }
        }

        if (bestMatch == null || maxCount == 0) {
            throw new BestResultNotFound(search);
        }
        return bestMatch;
    }

    private int countSubstringOccurrences(String str, String substring) {
        int count = 0;
        int index = 0;
        int subLenght = substring.length();
        if (subLenght == 0) return 0;
        while ((index =  str.indexOf(substring, index)) != -1) {
            count++;
            index += subLenght;
        }
        return count;
    }

}
