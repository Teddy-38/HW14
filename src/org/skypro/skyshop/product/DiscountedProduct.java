package org.skypro.skyshop.product;

public class DiscountedProduct implements Product {
    private String name;
    private double price;
    private double discount;

    public DiscountedProduct(String name, double price, double discount) {
        this.name = name;
        this.price = price;
        this.discount = discount;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getPrice() {
        return price * (1 - discount / 100); // Логика применения скидки
    }

    // Реализация метода toString
    @Override
    public String toString() {
        return "Скидка на продукт: " + name + ", Оригинальная цена: " + price + ", Скидка: " + discount + "%";
    }
}