package org.skypro.skyshop.product;

import org.skypro.skyshop.search.Searchable;

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
}