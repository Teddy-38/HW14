package org.skypro.skyshop.search;

public class SearchEngine {

    private Searchable[] searchableItems;
    private int count = 0;

    public SearchEngine(int size) {
        searchableItems = new Searchable[size];
    }

    public void add(Searchable item) {
        if (count < searchableItems.length) {
            searchableItems[count] = item;
            count++;
        }
    }

    public Searchable[] search(String term) {
        Searchable[] results = new Searchable[5];
        int resultCount = 0;

        for (Searchable item : searchableItems) {
            if (item != null && resultCount < 5) {
                if (item.getSearchTerm().toLowerCase().contains(term.toLowerCase())) {
                    results[resultCount] = item;
                    resultCount++;
                }
            }
            if (resultCount >= 5) {
                break;
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