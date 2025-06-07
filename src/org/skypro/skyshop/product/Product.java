package org.skypro.skyshop.product;

import org.skypro.skyshop.search.Searchable;

import java.util.Objects;

public abstract class Product implements Searchable {
    private final String productName;

    public Product(String productName) {
        if(productName.isBlank()){
            throw new IllegalArgumentException("Неверное название продукта");
        }
        this.productName = productName;
    }

    public String getProductName() {
        return productName;
    }

    public abstract int getProductPrice();

    public abstract boolean isSpecial();

    @Override
    public String searchTerm() {
        return productName;
    }

    @Override
    public String getContentType() {
        return "Product";
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(productName, product.productName);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(productName);
    }
}