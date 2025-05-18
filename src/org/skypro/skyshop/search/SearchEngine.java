package org.skypro.skyshop.search;

public class SearchEngine {
    private final Searchable[] Searchable;

    public Searchable[] search(String string) {
        int i = 0;
        Searchable[] search = new Searchable[5];
        for (Searchable searchable : Searchable) {
            if (searchable != null && searchable.searchTerm().contains(string) && i < 5) {
                search[i] = searchable;
                i++;
            }
        }
        return search;
    }

    public void addSearchable(Searchable searchable) {
        for (int i = 0; i < Searchable.length; i++) {
            if (Searchable[i] == null) {
                Searchable[i] = searchable;
                break;
            }
        }
    }

    public Searchable findBestMatch(String string) throws BestResultNotFound {
        Searchable bestMatch = null;
        int maxCount = 0;

        for (Searchable searchable : Searchable) {
            if (searchable != null) {
                int count = countRepetition(searchable.searchTerm().toLowerCase(), string.toLowerCase());
                if (count > maxCount) {
                    maxCount = count;
                    bestMatch = searchable;
                }
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

    public SearchEngine(int size) {
        this.Searchable = new Searchable[size];
    }
}