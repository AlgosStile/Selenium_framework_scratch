package org.selenium.allure.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Класс страницы корзины, наследуемый от базовой страницы.
 * Предоставляет методы для работы с элементами на странице корзины.
 */
public class CartPage extends BasicPage {

    /**
     * Конструктор класса страницы корзины.
     *
     * @param driver Драйвер веб-браузера, используемый для управления страницей.
     */
    public CartPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Увеличить количество товара.
     * Нажимает на кнопку для увеличения количества товара в корзине дважды.
     */
    @Step("Increase product quantity")
    public void increaseProductQuantity() {
        WebElement increaseQuantityButton = driver.findElement(By.cssSelector("button[aria-label='Добавить один товар']"));
        increaseQuantityButton.click();
        increaseQuantityButton.click();
    }

    /**
     * Перейти к оформлению заказа.
     * Нажимает на кнопку для перехода к оформлению заказа.
     */
    @Step("Proceed to checkout")
    public void proceedToCheckout() {
        WebElement checkoutButton = driver.findElement(By.cssSelector("button.cart__button.button.button--primery"));
        checkoutButton.click();
    }
}
