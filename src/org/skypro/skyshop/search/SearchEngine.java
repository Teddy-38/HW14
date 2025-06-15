package org.skypro.skyshop.search;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class SearchEngine {
    private final Set<Searchable> searchableSet = new HashSet<>();

    /**
     * Ищет элементы, содержащие ключевое слово в их поисковом терме.
     * Результаты возвращаются в виде TreeSet, отсортированного с помощью SearchableComparator.
     *
     * @param keyWord Ключевое слово для поиска.
     * @return Отсортированное множество найденных элементов.
     */
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

        if (bestMatch == null || maxCount == 0) { // Добавлена проверка maxCount > 0
            throw new BestResultNotFound("Не найдено ни одного результата поиска: " + keyWord);
        }
        return bestMatch;
    }

    private int countRepetition(String text, String word) {
        if (word.isEmpty()) { // Предотвращение бесконечного цикла, если слово пустое
            return 0;
        }
        int count = 0;
        int index = 0;
        while ((index = text.indexOf(word, index)) != -1) {
            count++;
            index += word.length();
        }
        return count;
    }
}