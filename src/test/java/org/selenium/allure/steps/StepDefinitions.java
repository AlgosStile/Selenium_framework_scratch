package org.selenium.allure.steps;

import org.openqa.selenium.WebDriver;
import org.selenium.allure.config.UserConfig;
import org.selenium.allure.pages.CartPage;
import org.selenium.allure.pages.CheckoutPage;
import org.selenium.allure.pages.HomePage;
import org.selenium.allure.pages.YandexSearchPage;

public class StepDefinitions {
    private WebDriver driver;
    private HomePage homePage;
    private CheckoutPage checkoutPage;
    private CartPage cartPage;
    private YandexSearchPage yandexSearchPage;

    public StepDefinitions(WebDriver driver) {
        this.driver = driver;
        homePage = new HomePage(driver);
        checkoutPage = new CheckoutPage(driver);
        cartPage = new CartPage(driver);
        yandexSearchPage = new YandexSearchPage(driver);
    }

    public void completeOrder() {
        homePage.selectProductCategory("Телефоны");
        homePage.setPriceRange(1000, 30000);
        homePage.selectColor("Белый");
        homePage.selectMemory("8 Гб");
        homePage.applyFilters();
        homePage.addFirstProductToCart();
        homePage.goToCart();
        cartPage.increaseProductQuantity();
        cartPage.proceedToCheckout();
        checkoutPage.selectPaymentMethod("Наличными при получении");
        checkoutPage.selectDeliveryMethod("Самовывоз бесплатно");
        checkoutPage.selectPaymentMethod("Картой при получении");
        checkoutPage.selectDeliveryMethod("Курьером");
        checkoutPage.goToCheckout();
        cartPage.increaseProductQuantity();
        checkoutPage.selectFirstAvailableProduct();
        checkoutPage.proceedToCheckout();


        checkoutPage.selectPaymentMethodCash();
        checkoutPage.selectDeliveryMethodPickup();
        checkoutPage.goToCheckout();

        checkoutPage.fillOrderForm(
                UserConfig.USER_NAME,
                UserConfig.USER_ADRESS,
                UserConfig.USER_PHONE,
                UserConfig.USER_EMAIL,
                UserConfig.USER_COMMENT
        );
        boolean isOrderDetailsCorrect = checkoutPage.verifyOrderDetails(
                UserConfig.USER_NAME,
                UserConfig.USER_ADRESS,
                UserConfig.USER_PHONE,
                UserConfig.USER_EMAIL,
                UserConfig.USER_COMMENT
        );

        if (!isOrderDetailsCorrect) {
            throw new AssertionError("Данные заказа не совпадают с введенными данными.");
        }
    }

    public void searchOnYandex(String query) {
        yandexSearchPage.searchFor(query);
    }
}