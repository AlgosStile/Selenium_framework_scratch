package org.selenium.allure.steps;

import org.openqa.selenium.WebDriver;
import org.selenium.allure.config.UserConfig;
import org.selenium.allure.pages.CartPage;
import org.selenium.allure.pages.CheckoutPage;
import org.selenium.allure.pages.HomePage;
import org.selenium.allure.pages.YandexSearchPage;

public class StepDefinitions {
    private final HomePage homePage;
    private final CheckoutPage checkoutPage;
    private final CartPage cartPage;
    private final YandexSearchPage yandexSearchPage;

    public StepDefinitions(WebDriver driver) {
        homePage = new HomePage(driver);
        checkoutPage = new CheckoutPage(driver);
        cartPage = new CartPage(driver);
        yandexSearchPage = new YandexSearchPage(driver);
    }

    public void completeOrder() {
        homePage.selectProductCategory("Телефоны");
        homePage.setPriceRange(1000, 30000);
        homePage.selectProductWithColor("rgb(250, 250, 250)");
        homePage.selectMemory("8 Гб");
        homePage.applyFilters();
        homePage.addFirstProductToCart();
        homePage.goToCart();
        cartPage.increaseProductQuantity();
        cartPage.proceedToCheckout();
        cartPage.setProductQuantity(2);
        cartPage.increaseProductQuantity();
        checkoutPage.selectPaymentMethod("Наличными при получении");
        checkoutPage.selectDeliveryMethod("Самовывоз бесплатно");
        checkoutPage.selectPaymentMethod("Картой при получении");
        checkoutPage.selectDeliveryMethod("Курьером");
        checkoutPage.goToCheckout();
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