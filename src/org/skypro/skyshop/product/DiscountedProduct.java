package org.skypro.skyshop.product;

public class DiscountedProduct extends Product { private final int basePrice; private final int discount;
    public DiscountedProduct(String name, int basePrice, int discount) {
        super(name);
        this.basePrice = basePrice;
        this.discount = discount;
    }
    public int getPrice() {
        return basePrice - (basePrice * discount / 100);
    }
    public boolean isSpecial() {
        return true;
    }
    public String toString() {
        return getName() + ": " + getPrice() + " (" + discount + "%)";
    }
}
