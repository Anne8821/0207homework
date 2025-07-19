package org.skypro.skyshop;

import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.basket.ProductBasket;

public class App {
    public static void main(String[] args) {
        Product product1 = new Product("Рубашка", 2999);
        Product product2 = new Product("Брюки", 3950);
        Product product3 = new Product("Платье", 3999);
        Product product4 = new Product("Пальто", 6999);
        Product product5 = new Product("Туфли", 3290);
        Product product6 = new Product("Очки", 1299);

        ProductBasket basket = new ProductBasket();

        basket.addProduct(product1);
        basket.addProduct(product2);
        basket.addProduct(product3);
        basket.addProduct(product4);
        //  basket.addProduct(product5);
        basket.addProduct(product6);
        //проверить надпись о невозможно добавить в корзину

    //   basket.printBasket();

    //    System.out.println("Общая стоимость: " + basket.getTotalCost());

    //    System.out.println("Есть ли в корзине 'Платье'? " + basket.containsProduct("Платье"));

    //    System.out.println("Есть ли 'Туфли' в пустой корзине? " + basket.containsProduct("Туфли"));

    //   basket.clear();

    //    System.out.println("Общая стоимость после очистки: " + basket.getTotalPrice());

    }
}
