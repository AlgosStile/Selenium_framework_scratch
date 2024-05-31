package org.selenium.allure.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class CartPage extends BasicPage {

    @FindBy(how = How.XPATH, using = "//button[text()='+']")
    private WebElement increaseQuantityButton;

    @FindBy(how = How.XPATH, using = "//button[text()='Оформить заказ']")
    private WebElement checkoutButton;

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public void increaseProductQuantity() {
        increaseQuantityButton.click();
    }

    public void proceedToCheckout() {
        checkoutButton.click();
    }

// Другие
}