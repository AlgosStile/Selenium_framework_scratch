package org.selenium.allure.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

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

    public void fillOrderForm(String fio, String address, String phone, String email, String comment) {
        fioField.sendKeys(fio);
        addressField.sendKeys(address);
        phoneField.sendKeys(phone);
        emailField.sendKeys(email);
        commentField.sendKeys(comment);
        submitButton.click();
    }

    public void goToCheckout() {
        driver.get("https://algosstile.github.io/vue-app/checkout.html");
    }

    public void selectPaymentMethod(String paymentMethod) {
        new Select(paymentMethodSelect).selectByVisibleText(paymentMethod);

    }

    public void selectDeliveryMethod(String deliveryMethod) {
        new Select(deliveryMethodSelect).selectByVisibleText(deliveryMethod);

    }

}