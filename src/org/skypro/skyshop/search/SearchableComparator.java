package org.skypro.skyshop.search;

import java.util.Comparator;

public class SearchableComparator implements Comparator<Searchable> {
    @Override
    public int compare(Searchable o1, Searchable o2) {
        // Сначала сравниваем длину поискового термина, более длинный идёт впереди
        int lengthCompare = Integer.compare(o2.searchTerm().length(), o1.searchTerm().length());
        if (lengthCompare != 0) {
            return lengthCompare;
        }
        // Если длины равны, сравниваем сами термины лексикографически
        return o1.searchTerm().compareTo(o2.searchTerm());
    }
}