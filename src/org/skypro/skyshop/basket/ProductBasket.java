package org.skypro.skyshop.basket;
import org.skypro.skyshop.product.Product;

public class ProductBasket { private Product[] products = new Product[5]; private int productCount = 0;

    public void addProduct(Product product) {
        if (productCount < products.length) {
            products[productCount] = product;
            productCount++;
        } else {
            System.out.println("Невозможно добавить продукт.");
        }
    }

    public int getTotalPrice() {
        int totalPrice = 0;
        for (Product product : products) {
            if (product != null) {
                totalPrice += product.getPrice();
            }
        }
        return totalPrice;
    }

    public void printProducts() {
        if (productCount == 0) {
            System.out.println("В корзине пусто.");
            return;
        }
        for (Product product : products) {
            if (product != null) {
                System.out.println(product.getName() + ": " + product.getPrice());
            }
        }
        System.out.println("Итого: " + getTotalPrice());
    }

    public boolean containsProduct(String name) {
        for (Product product : products) {
            if (product != null && product.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    public void clearBasket() {
        for (int i = 0; i < products.length; i++) {
            products[i] = null;
        }
        productCount = 0;
    }
}