package org.skypro.skyshop;

import org.skypro.skyshop.product.*;
import org.skypro.skyshop.article.Article;
import org.skypro.skyshop.search.SearchEngine;
import org.skypro.skyshop.search.BestResultNotFound;
import org.skypro.skyshop.search.Searchable;

public class App {
    public static void main(String[] args) {
        SearchEngine searchEngine = new SearchEngine(10);

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

        // Демонстрация поиска
        try {
            Searchable bestMatch = searchEngine.findBestMatch("яблоки");
            System.out.println("Лучший результат для 'яблоки': " + bestMatch.getStringRepresentation());
        } catch (BestResultNotFound e) {
            System.out.println(e.getMessage());
        }

        try {
            Searchable bestMatch = searchEngine.findBestMatch("не существующий запрос");
            System.out.println("Лучший результат для 'не существующий запрос': " + bestMatch.getStringRepresentation());
        } catch (BestResultNotFound e) {
            System.out.println(e.getMessage());
        }
    }
}