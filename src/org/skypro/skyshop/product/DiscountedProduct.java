package org.skypro.skyshop.product;

public class DiscountedProduct extends Product {
    private final int basePrice;
    private final int sale;

    public DiscountedProduct(String productName, int basePrice, int sale) {
        super(productName);
        if (basePrice < 1 || sale < 0 || sale > 100) {
            throw new IllegalArgumentException("Неверная цена или скидка");
        }
        this.basePrice = basePrice;
        this.sale = sale;
    }

    @Override
    public int getProductPrice() {
        return (int) (basePrice - ((double) basePrice / 100 * sale));
    }

    @Override
    public String toString() {
        return getProductName() + "(со скидкой): " + getProductPrice() + " рублей. Скидка: " + sale + "%";
    }

    @Override
    public boolean isSpecial() {
        return true;
    }
}