package org.skypro.skyshop;

import org.skypro.skyshop.product.*;

public class Main {
    public static void main(String[] args) {
        try {
            Product product1 = new SimpleProduct(" ", 50); // Неправильное название
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            Product product2 = new SimpleProduct("Яблоко", -10); // Неправильная цена
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            Product product3 = new DiscountedProduct("Банан", 80, 110); // Неправильный процент
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}