package org.selenium.allure.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartPage extends BasicPage {
    public CartPage(WebDriver driver) {
        super(driver);
    }

    public void increaseProductQuantity() {
        WebElement increaseQuantityButton = driver.findElement(By.cssSelector("button[aria-label='Добавить один товар']"));
        increaseQuantityButton.click();
        increaseQuantityButton.click();
    }


    public void proceedToCheckout() {
        WebElement checkoutButton = driver.findElement(By.cssSelector("button.cart__button.button.button--primery"));
        checkoutButton.click();
    }
}