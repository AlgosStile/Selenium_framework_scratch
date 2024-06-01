package org.selenium.allure.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckoutPage extends BasicPage {
    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public void goToCheckout() {
        driver.get("https://algosstile.github.io/vue-app/index.html#/cart.html");
    }

    public void fillOrderForm(String fio, String address, String phone, String email, String comment) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        By fioLocator = By.xpath("//input[@placeholder='Введите ваше полное имя']");
        By addressLocator = By.name("address");
        By phoneLocator = By.name("phone");
        By emailLocator = By.name("email");
        By commentLocator = By.cssSelector("textarea.form__input.form__input--area");
        By submitButtonLocator = By.cssSelector("button.cart__button.button.button--primery");


        wait.until(ExpectedConditions.visibilityOfElementLocated(fioLocator));
        driver.findElement(fioLocator).clear();
        driver.findElement(fioLocator).sendKeys(fio);

        wait.until(ExpectedConditions.visibilityOfElementLocated(addressLocator));
        driver.findElement(addressLocator).clear();
        driver.findElement(addressLocator).sendKeys(address);

        wait.until(ExpectedConditions.visibilityOfElementLocated(phoneLocator));
        driver.findElement(phoneLocator).clear();
        driver.findElement(phoneLocator).sendKeys(phone);

        wait.until(ExpectedConditions.visibilityOfElementLocated(emailLocator));
        driver.findElement(emailLocator).clear();
        driver.findElement(emailLocator).sendKeys(email);

        wait.until(ExpectedConditions.visibilityOfElementLocated(commentLocator));
        driver.findElement(commentLocator).clear();
        driver.findElement(commentLocator).sendKeys(comment);

        wait.until(ExpectedConditions.elementToBeClickable(submitButtonLocator));
        driver.findElement(submitButtonLocator).click();
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
        new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public void proceedToOrder() {
        WebElement breadcrumbsLink = driver.findElement(By.cssSelector("a.breadcrumbs__link"));
        breadcrumbsLink.click();
    }

}