package org.skypro.skyshop.search;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class SearchEngine {
    private final ArrayList<Searchable> Searchable = new ArrayList<>();

    public Map<String, List<Searchable>> search(String string) {
        Map<String, List<Searchable>> search = new TreeMap<>();
        for (Searchable searchable : Searchable) {
            if (searchable.searchTerm().toLowerCase().contains(string.toLowerCase())) {
                search.computeIfAbsent(searchable.searchTerm(), l -> new ArrayList<>()).add(searchable);
            }
        }
        return search;
    }

    public void addSearchable(Searchable searchable) {
        Searchable.add(searchable);
    }

    public Searchable findBestMatch(String string) throws BestResultNotFound {
        Searchable bestMatch = null;
        int maxCount = 0;

        for (Searchable searchable : Searchable) {
            int count = countRepetition(searchable.searchTerm().toLowerCase(), string.toLowerCase());
            if (count > maxCount) {
                maxCount = count;
                bestMatch = searchable;
            }
        }

        if (bestMatch == null) {
            throw new BestResultNotFound("Не найдено ни одного результата поиска: " + string);
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