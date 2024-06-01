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
        homePage.setPriceRange(1000, 30000);//1
        homePage.selectProductWithColor("rgb(250, 250, 250)");//2
        homePage.selectMemory("8");//3
        homePage.selectProductCategory("Телефоны");//4
        homePage.applyFilters();//5
        homePage.addFirstProductToCart();//6
        homePage.goToCart();//7
        homePage.goToCartHeader();//8
        cartPage.increaseProductQuantity();//9
        cartPage.proceedToCheckout();//10
        checkoutPage.selectPaymentMethod("Наличными при получении");//11
        checkoutPage.selectDeliveryMethod("Самовывоз бесплатно");//12
        checkoutPage.goToCheckout();


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