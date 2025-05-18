package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.Arrays;

public class ProductBasket {
    private final Product[] productBasket = new Product[5];

    public void addProduct(Product product) {
        for (int i = 0; i < productBasket.length; i++) {
            if (productBasket[i] == null) {
                productBasket[i] = product;
                return;
            }
        }
        System.out.println("Невозможно добавить продукт");
    }

    public int fullPriceBasket() {
        int fullPrice = 0;
        for (Product product : productBasket) {
            if (product != null) {
                fullPrice += product.getProductPrice();
            }
        }
        return fullPrice;
    }

    public void printContentBasket() {
        int special = 0;
        for (Product product : productBasket) {
            if (product != null) {
                System.out.println(product);
            }
            if (product != null && product.isSpecial()) {
                special++;
            }
        }
        if (fullPriceBasket() == 0) {
            System.out.println("В корзине пусто");
        } else {
            System.out.printf("Итого: %s рублей\nСпециальных товаров: %s\n", fullPriceBasket(), special);
        }
    }

    public boolean nameProductBasket(String productName) {
        for (Product product : productBasket) {
            if (product != null && product.getProductName().equals(productName)) {
                return true;
            }
        }
        return false;
    }

    public void cleanBasket() {
        Arrays.fill(productBasket, null);
    }
}