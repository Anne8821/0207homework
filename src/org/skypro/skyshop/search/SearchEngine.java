package org.skypro.skyshop.search;

import java.util.ArrayList;
import java.util.List;

public class SearchEngine {
    private final List<Searchable> items;

    public SearchEngine(int capacity) {
        this.items = new ArrayList<>(capacity);
    }

    public void add(Searchable item) {
        if (items != null) {
            items.add(item);
        }
 //       System.out.println("Поисковик заполнен, добавить дополнительные элементы невозможно: " + item.getName());
    }

    public List<Searchable> search(String searchTerm) {
        List<Searchable> results = new ArrayList<>();
        for (Searchable item : items) {
            if (item != null && item.getSearchTerm().toLowerCase().contains(searchTerm.toLowerCase())) {
                results.add(item);
            }
        }
        return results;
    }

    public Searchable findBestMatch(String search) throws BestResultNotFound {
        if (search == null || search.isBlank()) {
            throw new BestResultNotFound(("Результат не найдет"));
        }

        Searchable bestMatch = null;
        int maxCount = -1;

        for (Searchable item : items) {
            if (item != null) {
                String searchTermLower = item.getSearchTerm().toLowerCase();
                String searchLower = search.toLowerCase();

                int count = countSubstringOccurrences(searchTermLower, searchLower);
                if (count > maxCount) {
                    maxCount = count;
                    bestMatch = item;
                }
            }
        }

        if (bestMatch == null || maxCount == 0) {
            throw new BestResultNotFound("Нет подходящих результатов");
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
