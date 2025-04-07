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
            if (item != null && item.getSearchTerm().toLowerCase().contains(term.toLowerCase())) {
                if (resultCount < results.length) {
                    results[resultCount] = item;
                    resultCount++;
                } else {
                    break; // Ограничиваем поиск до 5 результатов
                }
            }
        }
        return results;
    }
}