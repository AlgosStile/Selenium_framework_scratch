package org.selenium.allure.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

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

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public void goToCheckout() {
        driver.get("https://algosstile.github.io/vue-app/index.html#/cart.html");
    }

    public void fillOrderForm(String fio, String address, String phone, String email, String comment) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(fioField));
        fioField.clear();
        fioField.sendKeys(fio);

        wait.until(ExpectedConditions.visibilityOf(addressField));
        addressField.clear();
        addressField.sendKeys(address);

        wait.until(ExpectedConditions.visibilityOf(phoneField));
        phoneField.clear();
        phoneField.sendKeys(phone);

        wait.until(ExpectedConditions.visibilityOf(emailField));
        emailField.clear();
        emailField.sendKeys(email);

        wait.until(ExpectedConditions.visibilityOf(commentField));
        commentField.clear();
        commentField.sendKeys(comment);

        wait.until(ExpectedConditions.elementToBeClickable(submitButton));
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


    public void selectPaymentMethod(String paymentMethod) {
        WebElement paymentMethodLabel = driver.findElement(By.xpath("//label[contains(.,'Наличными при получении')]"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", paymentMethodLabel);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", paymentMethodLabel);
    }

    public void selectDeliveryMethod(String deliveryMethod) {
        WebElement deliveryMethodOption = driver.findElement(By.xpath("//label[contains(.,'Самовывоз')]"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", deliveryMethodOption);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", deliveryMethodOption);
    }

}