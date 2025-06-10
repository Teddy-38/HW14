package org.skypro.skyshop.search;

import java.util.*;
import java.util.stream.Collectors;

public class SearchEngine {
    private final Set<Searchable> searchableSet = new HashSet<>();

    public Set<Searchable> search(String keyWord) {
        return searchableSet.stream()
                .filter(searchable -> searchable.searchTerm().toLowerCase().contains(keyWord.toLowerCase()))
                .collect(Collectors.toCollection(() -> new TreeSet<>(new SearchableComparator())));
    }

    public void addSearchable(Searchable searchable) {
        searchableSet.add(searchable);
    }

    public Searchable findBestMatch(String keyWord) throws BestResultNotFound {
        Searchable bestMatch = null;
        int maxCount = 0;

        for (Searchable searchable : searchableSet) {
            int count = countRepetition(searchable.searchTerm().toLowerCase(), keyWord.toLowerCase());
            if (count > maxCount) {
                maxCount = count;
                bestMatch = searchable;
            }
        }

        if (bestMatch == null) {
            throw new BestResultNotFound("Не найдено ни одного результата поиска: " + keyWord);
        }
        return bestMatch;
    }

    private int countRepetition(String str, String subStr) {
        int count = 0;
        int index = 0;
        index = str.indexOf(subStr, index);
        while (index != -1) {
            count++;
            index += subStr.length();
            index = str.indexOf(subStr, index);
        }
        return count;
    }
}