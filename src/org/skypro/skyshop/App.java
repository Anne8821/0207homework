package org.skypro.skyshop;

import org.skypro.skyshop.product.*;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.Article;
import org.skypro.skyshop.search.BestResultNotFound;
import org.skypro.skyshop.search.SearchEngine;
import org.skypro.skyshop.search.Searchable;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) {
        try {
            // Создаем товары
            Product product1 = new SimpleProduct("Рубашка", 2999);
            Product product2 = new SimpleProduct("Брюки", 3950);
            Product product3 = new SimpleProduct("Платье", 3999);
            Product product4 = new SimpleProduct("Пальто", 6999);
            Product product5 = new SimpleProduct("Туфли", 3290);
            Product product6 = new SimpleProduct("Очки", 1299);

            Product incorrectProduct1 = new SimpleProduct(" ", 100);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка при создании нового продукта: " + e.getMessage());
        }

        try {
            Product incorrectProduct2 = new SimpleProduct("Сапоги", 10000);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка при создании нового продукта: " + e.getMessage());
        }

        try {
            Product discountProductIncorrect = new DiscountedProduct("Сланцы", 9999, -10);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка при создании скидочного продукта в коллекции: " + e.getMessage());
        }

        try {
            Product discountProductIncorrect2 = new DiscountedProduct("Сланцы", 9999, 1000);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка при создании скидочного продукта в коллекции: " + e.getMessage());
        }

        Product discountProduct = new DiscountedProduct("Кроссовки со скидкой", 10000, 20);
        Product fixPriceProduct = new FixPriceProduct("Журнал о моде");

        // Создаем корзину
        ProductBasket basket = new ProductBasket();

        // Добавляем товары
        // basket.addProduct(product1);
        // basket.addProduct(product2);
        // basket.addProduct(product3);
        // basket.addProduct(product4);
        basket.addProduct(discountProduct);
        basket.addProduct(fixPriceProduct);
        // Попытка добавить 6-й товар - корзина полна
        // basket.addProduct(product5);
        // basket.addProduct(product6); // добавление после заполнения корзины не происходит

        Article article1 = new Article("Очки", "Как сочетать очки с Вашим образом");
        Article article2 = new Article("Обувь", "Угги все еще в моде?");

        // Используем конструктор без аргументов
        SearchEngine searchEngine = new SearchEngine();
        searchEngine.add(discountProduct);
        searchEngine.add(fixPriceProduct);
        searchEngine.add(article1);
        searchEngine.add(article2);

        try {
            Searchable best = searchEngine.findBestMatch("Обувь");
            System.out.println("Лучшее совпадение: " + best.getStringRepresentation());
        } catch (BestResultNotFound e) {
            System.out.println(e.getMessage());
        }

        try {
            Searchable best = searchEngine.findBestMatch("Несуществующий");
            System.out.println("Лучшее совпадение: " + best.getStringRepresentation());
        } catch (BestResultNotFound e) {
            System.out.println(e.getMessage());
        }

        Searchable[] results = searchEngine.search("Очки").values().toArray(new Searchable[0]);
        System.out.println("Результаты поиска по Очки: ");
        for (Searchable result : results) {
            System.out.println(result);
        }

        results = searchEngine.search("Статья").values().toArray(new Searchable[0]);
        System.out.println("Результаты поиска по Статья: ");
        for (Searchable result : results) {
            System.out.println(result);
        }

        Map<String, Searchable> resultsMap = searchEngine.search("Обувь");
        System.out.println("Результаты поиска по Обувь:");
        for (Map.Entry<String, Searchable> entry : resultsMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue().getStringRepresentation());
        }

        System.out.println("Содержимое корзины: ");
        // Выводим содержимое корзины
        basket.printBasket();

        // Общая стоимость
        System.out.println("Общая стоимость: " + basket.getTotalCost());

        System.out.println("Удаление продукта Платье");
        List<Product> removed = basket.removeProductsByName("Платье");
        if (removed.isEmpty()) {
            System.out.println("Продукт Платье не найден для удаления");
        } else {
            System.out.println("Удаленные продукты");
            for (Product p : removed) {
                System.out.println(p);
            }
        }

        System.out.println("Содержимое корзины после удаления");
        basket.printBasket();

        System.out.println("Попытка удалить несуществующих продукт Куртка");
        List<Product> removedNonExistent = basket.removeProductsByName("Куртка");
        if (removedNonExistent.isEmpty()) {
            System.out.println(false);
        }
        System.out.println("Содержимое корзины после попытки удаления несуществующего продукта:");
        basket.printBasket();

        // Проверка наличия товаров
        // System.out.println("Есть ли в корзине 'Платье'? " + basket.containsProduct("Платье"));
        // System.out.println("Есть ли 'Туфли' в корзине? " + basket.containsProduct("Туфли"));

        // Очистка корзины
        // basket.clear();

        // System.out.println("После очистки:");
        // basket.printBasket();
        // System.out.println("Общая стоимость после очистки: " + basket.getTotalCost());
    }
}