package org.skypro.skyshop.article;

import org.skypro.skyshop.product.Product;

public class Article implements Product {
    private String name;
    private double price;

    // Конструктор и другие методы...

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getPrice() {
        return price;
    }
}