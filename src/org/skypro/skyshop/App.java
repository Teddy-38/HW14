package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket; import org.skypro.skyshop.product.DiscountedProduct; import org.skypro.skyshop.product.FixPriceProduct; import org.skypro.skyshop.product.SimpleProduct;

public class App {
    public static void main(String[] args) {
        ProductBasket basket = new ProductBasket();

        SimpleProduct simpleProduct = new SimpleProduct("Яблоко", 50);
        DiscountedProduct discountedProduct = new DiscountedProduct("Банан", 30, 10); // скидка 10%
        FixPriceProduct fixPriceProduct = new FixPriceProduct("Апельсин");

        basket.addProduct(simpleProduct);
        basket.addProduct(discountedProduct);
        basket.addProduct(fixPriceProduct);

        basket.addProduct(new SimpleProduct("Киви", 70));
        basket.addProduct(new SimpleProduct("Груша", 60));

        System.out.println("Содержимое корзины:");
        basket.printProducts();

        System.out.println("Общая стоимость корзины: " + basket.getTotalPrice());

        System.out.println("Корзина содержит 'Яблоко': " + basket.containsProduct("Яблоко"));
        System.out.println("Корзина содержит 'Персик': " + basket.containsProduct("Персик"));

        basket.clearBasket();
        System.out.println("После очистки корзины:");

        basket.printProducts();

        System.out.println("Общая стоимость пустой корзины: " + basket.getTotalPrice());
    }
}
