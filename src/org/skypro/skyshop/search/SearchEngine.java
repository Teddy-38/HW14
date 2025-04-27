package org.skypro.skyshop.search;

import java.util.ArrayList;
import java.util.List;

public class SearchEngine {
    private final List<Searchable> searchableItems;

    public SearchEngine() {
        this.searchableItems = new ArrayList<>();
    }

    public void add(Searchable item) {
        searchableItems.add(item);
    }

    public List<Searchable> search(String term) {
        List<Searchable> results = new ArrayList<>();

        for (Searchable item : searchableItems) {
            if (item.getSearchTerm().toLowerCase().contains(term.toLowerCase())) {
                results.add(item);
            }
        }

        return results;
    }

    public Searchable findBestMatch(String search) throws BestResultNotFound {
        Searchable bestMatch = null;
        int maxOccurrences = 0;

        for (Searchable item : searchableItems) {
            if (item != null) {
                int occurrences = countOccurrences(item.getSearchTerm(), search);
                if (occurrences > maxOccurrences) {
                    maxOccurrences = occurrences;
                    bestMatch = item;
                }
            }
        }

        if (bestMatch == null) {
            throw new BestResultNotFound("Не найден подходящий элемент для запроса: " + search);
        }

        return bestMatch;
    }

    private int countOccurrences(String str, String subStr) {
        int count = 0;
        int index = 0;

        while ((index = str.indexOf(subStr, index)) != -1) {
            count++;
            index += subStr.length(); // Перемещаем индекс к следующему символу после текущего вхождения
        }

        return count;
    }
}