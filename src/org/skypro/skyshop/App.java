package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket; import org.skypro.skyshop.product.Product;

public class App {
    public static void main(String[] args) {
        ProductBasket basket = new ProductBasket();

        Product product1 = new Product("Яблоко", 100);
        Product product2 = new Product("Банан", 90);
        Product product3 = new Product("Апельсин", 80);
        Product product4 = new Product("Киви", 70);
        Product product5 = new Product("Груша", 60);
        Product product6 = new Product("Вишня", 50);

        basket.addProduct(product1);
        basket.addProduct(product2);
        basket.addProduct(product3);
        basket.addProduct(product4);
        basket.addProduct(product5);

        basket.addProduct(product6);

        System.out.println("Содержимое корзины:");
        basket.printProducts();

        System.out.println("Общая стоимость корзины: " + basket.getTotalPrice());

        System.out.println("Корзина содержит 'Яблоко': " + basket.containsProduct("Яблоко"));

        System.out.println("Корзина содержит 'Персик': " + basket.containsProduct("Персик"));

        basket.clearBasket();
        System.out.println("После очистки корзины:");

        basket.printProducts();

        System.out.println("Общая стоимость пустой корзины: " + basket.getTotalPrice());

        System.out.println("Корзина содержит 'Яблоко': " + basket.containsProduct("Яблоко"));
    }
}

