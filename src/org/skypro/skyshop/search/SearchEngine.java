package org.skypro.skyshop.search;

import java.util.Set;
import java.util.HashSet;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class SearchEngine {
    private final Set<Searchable> database;

    public SearchEngine() {
        this.database = new HashSet<>();
    }

    public void add(Searchable item) {
        if (item != null) {
            database.add(item);
        }
    }

    public Set<Searchable> search(String query) {
        return database.stream()
                .filter(item -> item != null && item.matches(query))
                .collect(Collectors.toCollection(() -> new TreeSet<>(new SearchableComparator())));
    }

    public Searchable findBestMatch(String query) throws BestResultNotFound {
        Searchable bestMatch = null;
        int maxScore = -1;
        for (Searchable item : database) {
            if (item != null) {
                String name = item.getStringRepresentation().toLowerCase();
                String q = query.toLowerCase();
                int score = 0;
                if (name.contains(q)) {
                    score = q.length();
                }
                if (score > maxScore) {
                    maxScore = score;
                    bestMatch = item;
                }
            }
        }
        if (bestMatch == null) {
            throw new BestResultNotFound("Совпадений не найдено");
        }
        return bestMatch;
    }
}

