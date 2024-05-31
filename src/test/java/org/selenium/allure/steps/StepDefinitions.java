package org.selenium.allure.steps;

import org.openqa.selenium.WebDriver;
import org.selenium.allure.config.UserConfig;
import org.selenium.allure.pages.HomePage;
import org.selenium.allure.pages.CheckoutPage;

public class StepDefinitions {
    private WebDriver driver;
    private HomePage homePage;
    private CheckoutPage checkoutPage;

    public StepDefinitions(WebDriver driver) {
        this.driver = driver;
        homePage = new HomePage(driver);
        checkoutPage = new CheckoutPage(driver);
    }

    public void completeOrder() {
        homePage.selectProductCategory("Телефоны");
        homePage.setPriceRange(1000, 30000);
        homePage.selectColor("Белый");
        homePage.selectMemory("8 Гб");
        homePage.applyFilters();

        checkoutPage.goToCheckout();

        checkoutPage.fillOrderForm(
                UserConfig.USER_NAME,
                UserConfig.USER_ADRESS,
                UserConfig.USER_PHONE,
                UserConfig.USER_EMAIL,
                UserConfig.USER_COMMENT
        );

    }


}