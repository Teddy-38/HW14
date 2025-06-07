package org.skypro.skyshop.search;

import java.util.*;

public class SearchEngine {
    private final Set<Searchable> Searchable = new HashSet<>();

    public Set<Searchable> search(String keyWord) {
        Set<Searchable> search = new TreeSet<>(new SearchableComparator());
        for (Searchable searchable : Searchable) {
            if (searchable.searchTerm().toLowerCase().contains(keyWord.toLowerCase())) {
                search.add(searchable);
            }
        }
        return search;
    }

    public void addSearchable(Searchable searchable) {
        Searchable.add(searchable);
    }

    public Searchable findBestMatch(String keyWord) throws BestResultNotFound {
        Searchable bestMatch = null;
        int maxCount = 0;

        for (Searchable searchable : Searchable) {
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