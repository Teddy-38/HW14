package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.*;


public class ProductBasket {
    private final Map<String, List<Product>> productBasket = new TreeMap<>();

    public void addProduct(Product product) {
        productBasket.computeIfAbsent(product.getProductName(), p -> new ArrayList<>()).add(product);
    }

    public void removeProduct(String name) {
        List<Product> removed = productBasket.remove(name);
        if (removed != null) {
            System.out.println("Удалённые продукты:" + removed);
        } else {
            System.out.println("Список удалённых продуктов пуст");
        }

    }

    public int fullPriceBasket() {
        int fullPrice = 0;
        for (List<Product> productList : productBasket.values()) {
            for (Product product : productList) {
                fullPrice += product.getProductPrice();
            }
        }
        return fullPrice;
    }

    public void printContentBasket() {
        System.out.println("\nПечать содержимого корзины:");
        if (productBasket.isEmpty()) {
            System.out.println("В корзине пусто");
            return;
        }
        int special = 0;
        for (List<Product> productList : productBasket.values()) {
            for (Product product : productList) {
                System.out.println(product);
                if (product.isSpecial()) {
                    special++;
                }
            }
        }
        System.out.printf("Итого: %s рублей\nСпециальных товаров: %s\n\n", fullPriceBasket(), special);

    }


    public boolean nameProductBasket(String productName) {
        for (List<Product> productList : productBasket.values()) {
            for (Product product : productList) {
                if (product.getProductName().equals(productName)) {
                    return true;
                }
            }
        }
        return false;
    }

    public void cleanBasket() {
        productBasket.clear();
    }
}