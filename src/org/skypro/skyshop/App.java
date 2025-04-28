package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.*;

import java.util.List;

public class App {
    public static void main(String[] args) {
        ProductBasket basket = new ProductBasket();

        Product product1 = new SimpleProduct("Яблоко", 50);
        Product product2 = new SimpleProduct("Банан", 55);
        Product product3 = new DiscountedProduct("Яблоко", 80, 10);

        basket.add(product1);
        basket.add(product2);
        basket.add(product3);

        List<Product> removedProducts = basket.removeByName("Яблоко");
        System.out.println("Удаленные продукты:");
        for (Product removed : removedProducts) {
            System.out.println(removed);
        }
        basket.printBasket();

        removedProducts = basket.removeByName("Груша");
        if (removedProducts.isEmpty()) {
            System.out.println("Список пуст");
        }
        basket.printBasket();
    }
}