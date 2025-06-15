package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product; // Убедитесь, что путь к Product корректен

import java.util.*;
import java.util.stream.Collectors;

public class ProductBasket {
    private final Map<String, List<Product>> productBasket = new TreeMap<>();

    public void addProduct(Product product) {
        productBasket.computeIfAbsent(product.getProductName(), k -> new ArrayList<>()).add(product);
    }

    public void removeProduct(String name) {
        List<Product> removed = productBasket.remove(name);
        if (removed != null && !removed.isEmpty()) {
            System.out.println("Удалённые продукты:" + removed);
        } else {
            System.out.println("Продукты с именем '" + name + "' не найдены для удаления или список был пуст.");
        }
    }

    /**
     * Рассчитывает полную стоимость всех товаров в корзине.
     *
     * @return общая стоимость.
     */
    public int fullPriceBasket() {
        return productBasket.values().stream() // Stream<List<Product>>
                .flatMap(Collection::stream)   // Stream<Product> - "расплющиваем" списки продуктов
                .mapToInt(Product::getProductPrice) // IntStream - получаем цены продуктов
                .sum();                        // Суммируем все цены
    }

    /**
     * Приватный метод для подсчета количества специальных товаров в корзине.
     *
     * @return количество специальных товаров.
     */
    private long getSpecialCount() {
        return productBasket.values().stream() // Stream<List<Product>>
                .flatMap(Collection::stream)   // Stream<Product>
                .filter(Product::isSpecial)    // Stream<Product> - только специальные товары
                .count();                     // Считаем количество
    }

    /**
     * Печатает содержимое корзины, включая общую стоимость и количество специальных товаров.
     */
    public void printContentBasket() {
        System.out.println("\nПечать содержимого корзины:");
        if (productBasket.isEmpty()) {
            System.out.println("В корзине пусто");
            return;
        }

        // Печатаем каждый продукт. TreeMap обеспечит порядок по ключам (именам продуктов/категорий).
        // flatMap сохранит порядок элементов внутри каждого списка.
        productBasket.values().stream()
                .flatMap(Collection::stream) // Stream<Product>
                .forEach(System.out::println); // Печатаем каждый продукт (требует Product.toString())

        System.out.printf("Итого: %s рублей\nСпециальных товаров: %s\n\n", fullPriceBasket(), getSpecialCount());
    }


    /**
     * Проверяет, есть ли в корзине продукт с указанным именем.
     * (Имя продукта здесь используется как ключ в карте).
     *
     * @param productName имя продукта для поиска.
     * @return true, если продукт с таким именем есть в корзине, иначе false.
     */
    public boolean nameProductBasket(String productName) {
        // Если продукт с таким именем (ключом) есть, и список продуктов для этого имени не пуст.
        // Оригинальный цикл проверял имя каждого продукта, что избыточно, если ключ карты - это и есть имя продукта.
        // Приведенная ниже Stream-версия точно повторяет логику исходного цикла:
        return productBasket.values().stream() // Stream<List<Product>>
                .flatMap(Collection::stream)   // Stream<Product>
                .anyMatch(product -> product.getProductName().equals(productName)); // Проверяем имя каждого продукта

        // Более эффективный вариант, если ключ карты productBasket - это и есть product.getProductName():
        // return productBasket.containsKey(productName) && !productBasket.get(productName).isEmpty();
    }

    public void cleanBasket() {
        productBasket.clear();
        System.out.println("Корзина очищена.");
    }

    // Для тестирования, предполагаем существование класса Product
    // package org.skypro.skyshop.product;
    // public class Product {
    //     private String productName;
    //     private int productPrice;
    //     private boolean special;
    //
    //     public Product(String productName, int productPrice, boolean special) {
    //         this.productName = productName;
    //         this.productPrice = productPrice;
    //         this.special = special;
    //     }
    //
    //     public String getProductName() { return productName; }
    //     public int getProductPrice() { return productPrice; }
    //     public boolean isSpecial() { return special; }
    //
    //     @Override
    //     public String toString() {
    //         return productName + " (Цена: " + productPrice + " руб." + (special ? ", Специальный" : "") + ")";
    //     }
    // }

    public static void main(String[] args) {
        // Пример использования ProductBasket
        ProductBasket basket = new ProductBasket();
        // Убедитесь, что у вас есть класс Product с конструктором и методами getProductName, getProductPrice, isSpecial
        // Например: import org.skypro.skyshop.product.Product;

        // Product p1 = new Product("Молоко", 80, false);
        // Product p2 = new Product("Хлеб", 50, false);
        // Product p3 = new Product("Сыр (акция)", 200, true);
        // Product p4 = new Product("Молоко", 85, false); // Еще одна упаковка молока

        // basket.addProduct(p1);
        // basket.addProduct(p2);
        // basket.addProduct(p3);
        // basket.addProduct(p4); // Добавит в список "Молоко"

        // basket.printContentBasket();
        // System.out.println("Продукт 'Хлеб' в корзине: " + basket.nameProductBasket("Хлеб"));
        // System.out.println("Продукт 'Масло' в корзине: " + basket.nameProductBasket("Масло"));

        // basket.removeProduct("Молоко");
        // basket.printContentBasket();

        // basket.cleanBasket();
        // basket.printContentBasket();
    }
}