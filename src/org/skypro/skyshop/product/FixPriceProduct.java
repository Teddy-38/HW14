package org.skypro.skyshop.product;

public class FixPriceProduct extends Product { private static final int FIXED_PRICE = 100;
    public FixPriceProduct(String name) {
        super(name);
    }

    public int getPrice() {
        return FIXED_PRICE;
    }

    public boolean isSpecial() {
        return true;
    }

    public String toString() {
        return getName() + ": Фиксированная цена " + FIXED_PRICE;
    }
}
