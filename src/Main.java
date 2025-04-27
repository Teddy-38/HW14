package org.skypro.skyshop;

import org.skypro.skyshop.product.*;
import org.skypro.skyshop.article.Article;
import org.skypro.skyshop.search.SearchEngine;
import org.skypro.skyshop.search.BestResultNotFound;
import org.skypro.skyshop.search.Searchable;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        SearchEngine searchEngine = new SearchEngine();

        // Создание продуктов и добавление их в поисковый движок
        Product product1 = new SimpleProduct("Яблоко", 50);
        Product product2 = new DiscountedProduct("Банан", 80, 10);
        Product product3 = new FixPriceProduct("Апельсин");

        searchEngine.add(product1);
        searchEngine.add(product2);
        searchEngine.add(product3);

        // Создание статей и добавление их в поисковый движок
        Article article1 = new Article("Как выбрать яблоки", "На что обращать внимание при выборе яблок.");
        Article article2 = new Article("Грипп и его симптомы", "Как распознать грипп и что с ним делать.");

        searchEngine.add(article1);
        searchEngine.add(article2);

        // Поиск
        System.out.println("\nПоиск всех предметов по 'яблоки':");
        List<Searchable> searchResults = searchEngine.search("яблоки");
        for (Searchable result : searchResults) {
            System.out.println(result.getStringRepresentation());
        }

        System.out.println("\nПопытка поиска по несуществующему запросу:");
        try {
            Searchable bestMatch = searchEngine.findBestMatch("не существующий запрос");
            System.out.println("Лучший результат для 'не существующий запрос': " + bestMatch.getStringRepresentation());
        } catch (BestResultNotFound e) {
            System.out.println(e.getMessage());
        }
    }
}