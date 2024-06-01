package org.selenium.allure.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class CartPage extends BasicPage {

    @FindBy(how = How.XPATH, using = "//button[@aria-label='Добавить один товар']")
    private WebElement increaseQuantityButton;

    @FindBy(how = How.XPATH, using = "//button[text()='Оформить заказ']")
    private WebElement checkoutButton;

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


    public void setProductQuantity(int quantity) {
        WebElement quantityInput = driver.findElement(By.xpath("//button[@aria-label='Добавить один товар']"));
        quantityInput.clear();
        quantityInput.sendKeys(String.valueOf(quantity));
    }
}