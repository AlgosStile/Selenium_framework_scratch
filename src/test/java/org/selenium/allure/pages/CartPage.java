package org.selenium.allure.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Класс CartPage представляет страницу корзины товаров.
 */
public class CartPage extends BasicPage {

    /**
     * Конструктор класса CartPage, принимающий веб-драйвер.
     *
     * @param driver Веб-драйвер для инициализации страницы корзины.
     */
    public CartPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Увеличивает количество продукта в корзине.
     * Нажимает на кнопку увеличения количества товара дважды.
     */
    public void increaseProductQuantity() {
        WebElement increaseQuantityButton = driver.findElement(By.cssSelector("button[aria-label='Добавить один товар']"));
        increaseQuantityButton.click();
        increaseQuantityButton.click();
    }

    /**
     * Переходит к оформлению заказа, нажимая на кнопку "Оформить заказ".
     */
    public void proceedToCheckout() {
        WebElement checkoutButton = driver.findElement(By.cssSelector("button.cart__button.button.button--primery"));
        checkoutButton.click();
    }
}

