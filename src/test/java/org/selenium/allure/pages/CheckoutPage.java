package org.selenium.allure.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class CheckoutPage extends BasicPage {

    @FindBy(how = How.ID, using = "fio")
    private WebElement fioField;
    @FindBy(how = How.ID, using = "address")
    private WebElement addressField;
    @FindBy(how = How.ID, using = "phone")
    private WebElement phoneField;
    @FindBy(how = How.ID, using = "email")
    private WebElement emailField;
    @FindBy(how = How.ID, using = "comment")
    private WebElement commentField;
    @FindBy(how = How.ID, using = "submit")
    private WebElement submitButton;

    @FindBy(how = How.ID, using = "payment-method")
    private WebElement paymentMethodSelect;

    @FindBy(how = How.ID, using = "delivery-method")
    private WebElement deliveryMethodSelect;

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public void goToCheckout() {
        driver.get("https://algosstile.github.io/vue-app/index.html#/cart.html");
    }

    public void fillOrderForm(String fio, String address, String phone, String email, String comment) {
        fioField.sendKeys(fio);
        addressField.sendKeys(address);
        phoneField.sendKeys(phone);
        emailField.sendKeys(email);
        commentField.sendKeys(comment);
        submitButton.click();
    }

    public boolean verifyOrderDetails(String fio, String address, String phone, String email, String comment) {
        WebElement fioInfo = driver.findElement(By.id("order-fio"));
        WebElement addressInfo = driver.findElement(By.id("order-address"));
        WebElement phoneInfo = driver.findElement(By.id("order-phone"));
        WebElement emailInfo = driver.findElement(By.id("order-email"));
        WebElement commentInfo = driver.findElement(By.id("order-comment"));

        return fioInfo.getText().equals(fio) &&
                addressInfo.getText().equals(address) &&
                phoneInfo.getText().equals(phone) &&
                emailInfo.getText().equals(email) &&
                commentInfo.getText().equals(comment);
    }

    public void selectFirstAvailableProduct() {
        List<WebElement> products = driver.findElements(By.cssSelector(".product-item"));
        if (!products.isEmpty()) {
            WebElement firstProduct = products.get(0);
            WebElement selectButton = firstProduct.findElement(By.cssSelector(".button--primery"));
            selectButton.click();
        } else {
            throw new AssertionError("Товары не найдены.");
        }
    }


    public void selectPaymentMethod(String paymentMethod) {
        new Select(paymentMethodSelect).selectByVisibleText(paymentMethod);

    }

    public void selectDeliveryMethod(String deliveryMethod) {
        new Select(deliveryMethodSelect).selectByVisibleText(deliveryMethod);

    }

    public void selectPaymentMethodCash() {
        new Select(paymentMethodSelect).selectByVisibleText("Наличными при получении");
    }

    public void selectDeliveryMethodPickup() {
        new Select(deliveryMethodSelect).selectByVisibleText("Самовывоз бесплатно");
    }

    public void proceedToCheckout() {
        submitButton.click();
    }

}