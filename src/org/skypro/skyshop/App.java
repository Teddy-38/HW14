package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket; import org.skypro.skyshop.product.DiscountedProduct; import org.skypro.skyshop.product.FixPriceProduct; import org.skypro.skyshop.product.SimpleProduct; import org.skypro.skyshop.article.Article; import org.skypro.skyshop.search.SearchEngine;
import org.skypro.skyshop.search.Searchable;

public class App {
    public static void main(String[] args) {
        ProductBasket basket = new ProductBasket();
        SearchEngine searchEngine = new SearchEngine(10);

        SimpleProduct simpleProduct = new SimpleProduct("Яблоко", 50);
        DiscountedProduct discountedProduct = new DiscountedProduct("Банан", 30, 10); // скидка 10%
        FixPriceProduct fixPriceProduct = new FixPriceProduct("Апельсин");

        basket.addProduct(simpleProduct);
        basket.addProduct(discountedProduct);
        basket.addProduct(fixPriceProduct);

        searchEngine.add(simpleProduct);
        searchEngine.add(discountedProduct);
        searchEngine.add(fixPriceProduct);

        Article article1 = new Article("Обзор Яблок", "Яблоки содержат много витаминов и полезных веществ.");
        Article article2 = new Article("Как выбрать бананы", "Бананы должны быть желтыми, без пятен.");

        searchEngine.add(article1);
        searchEngine.add(article2);

        System.out.println("Результаты поиска по 'яблоко':");
        for (Searchable item : searchEngine.search("яблоко")) {
            if (item != null) {
                System.out.println(item.getStringRepresentation());
            }
        }

        System.out.println("\nРезультаты поиска по 'банан':");
        for (Searchable item : searchEngine.search("банан")) {
            if (item != null) {
                System.out.println(item.getStringRepresentation());
            }
        }

        System.out.println("\nРезультаты поиска по 'обзору':");
        for (Searchable item : searchEngine.search("обзору")) {
            if (item != null) {
                System.out.println(item.getStringRepresentation());
            }
        }
    }
}