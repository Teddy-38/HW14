package org.skypro.skyshop;

import org.skypro.skyshop.article.Article;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.search.SearchEngine;
import org.skypro.skyshop.search.BestResultNotFound;

import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        SimpleProduct apple = new SimpleProduct("Яблоко", 40);
        SimpleProduct potato = new SimpleProduct("Картофель", 10);
        DiscountedProduct pasta = new DiscountedProduct("Макароны", 100, 10);
        SimpleProduct orange = new SimpleProduct("Апельсин", 140);
        DiscountedProduct sausage = new DiscountedProduct("Колбаса", 250, 15);
        DiscountedProduct milk = new DiscountedProduct("Молоко", 90, 20);

        ProductBasket basket1 = new ProductBasket();
        ProductBasket basket2 = new ProductBasket();

        System.out.println("Демонстрация методов");

        System.out.println("Добавление продукта в корзину.");
        basket1.addProduct(apple);
        basket1.addProduct(milk);
        basket1.addProduct(apple);
        basket1.addProduct(orange);
        basket2.addProduct(potato);
        basket2.addProduct(pasta);
        basket2.addProduct(sausage);

        System.out.println("Добавление продукта в заполненную корзину, в которой нет свободного места.");
        basket1.addProduct(orange);

        System.out.println("Получение стоимости корзины с несколькими товарами.");
        System.out.printf("Итого: %s рублей\n", basket1.fullPriceBasket());

        System.out.println("Печать содержимого корзины с несколькими товарами.");
        System.out.println("Корзина 1");
        basket1.printContentBasket();
        System.out.println("Корзина 2");
        basket2.printContentBasket();

        System.out.println("Поиск товара, который есть в корзине.");
        System.out.println(basket1.nameProductBasket("Молоко"));

        System.out.println("Поиск товара, которого нет в корзине.");
        System.out.println(basket1.nameProductBasket("Картофель"));

        System.out.println("Очистка корзины.");
        basket1.cleanBasket();

        System.out.println("Печать содержимого пустой корзины.");
        basket1.printContentBasket();

        System.out.println("Получение стоимости пустой корзины.");
        System.out.printf("Итого: %s рублей\n", basket1.fullPriceBasket());

        System.out.println("Поиск товара по имени в пустой корзине.");
        System.out.println(basket1.nameProductBasket("Яблоко"));

        SearchEngine Searchable = new SearchEngine(15);
        Searchable.addSearchable(apple);
        Searchable.addSearchable(milk);
        Searchable.addSearchable(apple);
        Searchable.addSearchable(orange);
        Searchable.addSearchable(potato);
        Searchable.addSearchable(pasta);
        Searchable.addSearchable(sausage);
        Article properMilk = new Article("Молоко", "Хорошее молоко должно быть жирным");
        Article ironApple = new Article("Яблоко", "Срез настоящего яблока быстро ржавеет");
        Article culinaryApple = new Article("Кулинарное яблоко", "Яблоко — универсальный ингредиент в кулинарии. " +
                "Его можно использовать для приготовления салатов, выпечки, или просто наслаждаться свежим яблоком. " +
                "Яблоко также идеально подходит для приготовления соков и компотов. " +
                "Вкусное яблоко всегда будет хорошим выбором для любого блюда");
        Searchable.addSearchable(properMilk);
        Searchable.addSearchable(ironApple);
        Searchable.addSearchable(culinaryApple);
        System.out.println(properMilk.getStringRepresentation());
        System.out.println(ironApple.getStringRepresentation());
        System.out.println(apple.getStringRepresentation());
        System.out.println(Arrays.toString(Searchable.search("Яблоко")));
        System.out.println(Arrays.toString(Searchable.search("Молоко")));

        System.out.println("Демонстрация исключений");
        try {
            SimpleProduct emptyName = new SimpleProduct(" ", 15);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка создания продукта: " + e.getMessage());
        }
        try {
            DiscountedProduct kefir = new DiscountedProduct("Кефир", 80, 120);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка создания продукта: " + e.getMessage());
        }
        try {
            SimpleProduct banana = new SimpleProduct("Банан", 0);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка создания продукта: " + e.getMessage());
        }
        try {
            System.out.println("Лучший результат поиска: " + Searchable.findBestMatch("Яблоко"));
        } catch (BestResultNotFound e) {
            System.out.println("Ошибка поиска: " + e.getMessage());
        }
        try {
            System.out.println("Лучший результат поиска: " + Searchable.findBestMatch("Томат"));
        } catch (BestResultNotFound e) {
            System.out.println("Ошибка поиска: " + e.getMessage());
        } finally {
            System.out.println("Демонстрация завершена");
        }
    }

}