package org.skypro.skyshop.product;

import java.util.Objects;

public class SimpleProduct extends Product {
    private final int productPrice;

    public SimpleProduct(String productName, int productPrice) {
        super(productName);
        if (productPrice<1){
            throw new IllegalArgumentException("Неверная цена");
        }
        this.productPrice = productPrice;
    }

    @Override
    public int getProductPrice() {
        return productPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        SimpleProduct that = (SimpleProduct) o;
        return productPrice == that.productPrice;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), productPrice);
    }

    @Override
    public String toString() {
        return getProductName() + ": " + productPrice + " рублей";
    }

    @Override
    public boolean isSpecial() {
        return false;
    }
}