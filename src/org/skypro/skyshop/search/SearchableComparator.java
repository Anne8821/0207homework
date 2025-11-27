package org.skypro.skyshop.search;

import java.util.Comparator;

public class SearchableComparator implements Comparator<Searchable> {
    @Override
    public int compare(Searchable object1, Searchable object2) {
        String name1 = object1.getName();
        String name2 = object2.getName();

        int lengthDiff = Integer.compare(name2.length(), name1.length());
        if (lengthDiff != 0) {
            return lengthDiff;
        }
        return name1.compareTo(name2);
    }
}
