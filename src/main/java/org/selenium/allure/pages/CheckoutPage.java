package org.selenium.allure.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.selenium.allure.config.UserConfig;

import java.time.Duration;

/**
 * Класс CheckoutPage представляет страницу оформления заказа.
 */
public class CheckoutPage extends BasicPage {

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    @Step("Fill order form")
    public void fillOrderForm() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        By fioLocator = By.xpath("//input[@placeholder='Введите ваше полное имя']");
        By addressLocator = By.name("address");
        By phoneLocator = By.name("phone");
        By emailLocator = By.name("email");
        By commentLocator = By.cssSelector("textarea.form__input.form__input--area");
        By submitButtonLocator = By.cssSelector("button.cart__button.button.button--primery");

        wait.until(ExpectedConditions.visibilityOfElementLocated(fioLocator));
        driver.findElement(fioLocator).clear();
        driver.findElement(fioLocator).sendKeys(UserConfig.getUser());

        wait.until(ExpectedConditions.visibilityOfElementLocated(addressLocator));
        driver.findElement(addressLocator).clear();
        driver.findElement(addressLocator).sendKeys(UserConfig.getUserAddress());

        wait.until(ExpectedConditions.visibilityOfElementLocated(phoneLocator));
        driver.findElement(phoneLocator).clear();
        driver.findElement(phoneLocator).sendKeys(UserConfig.getUserPhone());

        wait.until(ExpectedConditions.visibilityOfElementLocated(emailLocator));
        driver.findElement(emailLocator).clear();
        driver.findElement(emailLocator).sendKeys(UserConfig.getUserEmail());

        wait.until(ExpectedConditions.visibilityOfElementLocated(commentLocator));
        driver.findElement(commentLocator).clear();
        driver.findElement(commentLocator).sendKeys(UserConfig.getUserComment());

        wait.until(ExpectedConditions.elementToBeClickable(submitButtonLocator));
        driver.findElement(submitButtonLocator).click();
    }

    @Step("Verify order details")
    public boolean verifyOrderDetails(String fio, String address, String phone, String email, String comment) {
        WebElement fioInfo = driver.findElement(By.id("order-fio"));
        WebElement addressInfo = driver.findElement(By.id("order-address"));
        WebElement phoneInfo = driver.findElement(By.id("order-phone"));
        WebElement emailInfo = driver.findElement(By.id("order-email"));
        WebElement commentInfo = driver.findElement(By.id("order-comment"));

        return fioInfo.getText().equals(fio) && addressInfo.getText().equals(address) && phoneInfo.getText().equals(phone) && emailInfo.getText().equals(email) && commentInfo.getText().equals(comment);
    }

    @Step("Select payment method")
    public void selectPaymentMethod(String paymentMethod) {
        WebElement paymentMethodLabel = driver.findElement(By.xpath("//label[contains(.,'" + paymentMethod + "')]"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", paymentMethodLabel);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", paymentMethodLabel);
    }
    @Step("Select delivery method")
    public void selectDeliveryMethod(String deliveryMethod) {
        WebElement deliveryMethodOption = driver.findElement(By.xpath("//label[contains(.,'" + deliveryMethod + "')]"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", deliveryMethodOption);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", deliveryMethodOption);
        new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    @Step("Proceed to order")
    public void proceedToOrder() {
        WebElement breadcrumbsLink = driver.findElement(By.cssSelector("a.breadcrumbs__link"));
        breadcrumbsLink.click();
    }

}