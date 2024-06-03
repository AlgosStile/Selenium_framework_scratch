package org.selenium.allure.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Класс CartPage представляет страницу корзины товаров.
 */
public class CartPage extends BasicPage {

    public CartPage(WebDriver driver) {
        super(driver);
    }

    @Step("Increase product quantity")
    public void increaseProductQuantity() {
        WebElement increaseQuantityButton = driver.findElement(By.cssSelector("button[aria-label='Добавить один товар']"));
        increaseQuantityButton.click();
        increaseQuantityButton.click();
    }

    @Step("Proceed to checkout")
    public void proceedToCheckout() {
        WebElement checkoutButton = driver.findElement(By.cssSelector("button.cart__button.button.button--primery"));
        checkoutButton.click();
    }
}

