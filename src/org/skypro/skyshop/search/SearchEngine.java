package org.skypro.skyshop.search;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class SearchEngine {
    private final List<Searchable> database;

    public SearchEngine() {
        this.database = new ArrayList<>();
    }

    public void add(Searchable item) {
        if (item != null) {
            database.add(item);
        }
    }

    public Map<String, Searchable> search(String query) {
        Map<String, Searchable> resultMap = new TreeMap<>();
        for (Searchable item : database) {
            if (item != null && item.matches(query)) {
                resultMap.put(item.getName(), item);
            }
        }
        return resultMap;
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

//public class SearchEngine {
//    private final List<Searchable> items;

//    public SearchEngine(int capacity) {
//        this.items = new ArrayList<>(capacity);
//    }

//    public void add(Searchable item) {
//        if (items != null) {
 //           items.add(item);
 //       }
 //       System.out.println("Поисковик заполнен, добавить дополнительные элементы невозможно: " + item.getName());
//    }

 //   public List<Searchable> search(String searchTerm) {
  //      List<Searchable> results = new ArrayList<>();
  //      for (Searchable item : items) {
 //           if (item != null && item.getSearchTerm().toLowerCase().contains(searchTerm.toLowerCase())) {
 //               results.add(item);
 //           }
 //       }
 //       return results;
 //   }

 //   public Searchable findBestMatch(String search) throws BestResultNotFound {
 //       if (search == null || search.isBlank()) {
 //           throw new BestResultNotFound(("Результат не найдет"));
 //       }

 //       Searchable bestMatch = null;
 //       int maxCount = -1;

 //       for (Searchable item : items) {
 //           if (item != null) {
 //               String searchTermLower = item.getSearchTerm().toLowerCase();
 //               String searchLower = search.toLowerCase();

 //               int count = countSubstringOccurrences(searchTermLower, searchLower);
//                if (count > maxCount) {
//                    maxCount = count;
 //                   bestMatch = item;
 //               }
//            }
//        }

//       if (bestMatch == null || maxCount == 0) {
 //           throw new BestResultNotFound("Нет подходящих результатов");
//        }
 //       return bestMatch;
//    }

//    private int countSubstringOccurrences(String str, String substring) {
//        int count = 0;
//        int index = 0;
//        int subLenght = substring.length();
//        if (subLenght == 0) return 0;
//        while ((index =  str.indexOf(substring, index)) != -1) {
//            count++;
//            index += subLenght;
//        }
//        return count;
//    }
//}
