package org.skypro.skyshop.product;

public class SimpleProduct extends Product {
    private final int price;

    public SimpleProduct(String name, int price) {
        super(name);
        this.price = price;
    }
    public int getPrice() {
        return price;
    }
    public boolean isSpecial() {
        return false;
    }
    public String toString() {
        return getName() + ": " + getPrice();
    }
}
