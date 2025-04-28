package org.skypro.skyshop.product;

public class FixPriceProduct implements Product {
    private String name;
    private double price; // используем double для соответствия интерфейсу

    public FixPriceProduct(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getPrice() {
        return price; // возвращаем double
    }
}