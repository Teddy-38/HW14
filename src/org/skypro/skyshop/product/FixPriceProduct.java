package org.skypro.skyshop.product;

public class FixPriceProduct extends Product {
    private static final int fixPrice = 77;

    public FixPriceProduct(String productName) {
        super(productName);
    }

    @Override
    public int getProductPrice() {
        return fixPrice;
    }

    @Override
    public String toString() {
        return getProductName() + "(c фиксированной ценой): " + fixPrice + " рублей ";
    }

    @Override
    public boolean isSpecial() {
        return true;
    }
}