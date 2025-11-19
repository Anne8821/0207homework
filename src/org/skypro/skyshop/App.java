package org.skypro.skyshop;

import org.skypro.skyshop.product.*;
import org.skypro.skyshop.basket.ProductBasket;

public class App {
    public static void main(String[] args) {
        // Создаем товары
  //      Product product1 = new SimpleProduct("Рубашка", 2999);
  //      Product product2 = new SimpleProduct("Брюки", 3950);
  //      Product product3 = new SimpleProduct("Платье", 3999);
   //     Product product4 = new SimpleProduct("Пальто", 6999);
   //     Product product5 = new SimpleProduct("Туфли", 3290);
   //     Product product6 = new SimpleProduct("Очки", 1299);

        Product discountProduct = new DiscountedProduct("Кроссовки со скидкой", 10000, 20);
        Product fixPriceProduct = new FixPriceProduct("Книга");

        // Создаем корзину
        ProductBasket basket = new ProductBasket();

        // Добавляем товары
   //     basket.addProduct(product1);
    //    basket.addProduct(product2);
      //  basket.addProduct(product3);
     //   basket.addProduct(product4);
        basket.addProduct(discountProduct);
        basket.addProduct(fixPriceProduct);
        // Попытка добавить 6-й товар - корзина полна
      //  basket.addProduct(product5);
    //    basket.addProduct(product6); // добавление после заполнения корзины не происходит

        // Выводим содержимое корзины
        basket.printBasket();

        // Общая стоимость
        System.out.println("Общая стоимость: " + basket.getTotalCost());

        // Проверка наличия товаров
  //      System.out.println("Есть ли в корзине 'Платье'? " + basket.containsProduct("Платье"));
   //     System.out.println("Есть ли 'Туфли' в корзине? " + basket.containsProduct("Туфли"));

        // Очистка корзины
 //       basket.clear();

  //      System.out.println("После очистки:");
  //      basket.printBasket();
  //      System.out.println("Общая стоимость после очистки: " + basket.getTotalCost());
    }
}