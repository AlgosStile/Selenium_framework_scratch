package org.selenium.allure.steps;

import org.openqa.selenium.WebDriver;
import org.selenium.allure.config.UserConfig;
import org.selenium.allure.pages.CartPage;
import org.selenium.allure.pages.CheckoutPage;
import org.selenium.allure.pages.HomePage;

/**
 * Класс StepDefinitions содержит шаги для автоматизированного тестирования сценариев.
 */
public class StepDefinitions {

    private final HomePage homePage;
    private final CheckoutPage checkoutPage;
    private final CartPage cartPage;

    /**
     * Конструктор класса StepDefinitions.
     *
     * @param driver Веб-драйвер для инициализации страниц.
     */
    public StepDefinitions(WebDriver driver) {
        homePage = new HomePage(driver);
        checkoutPage = new CheckoutPage(driver);
        cartPage = new CartPage(driver);
    }

    /**
     * Выполняет заказ продукта.
     *
     * @throws InterruptedException Если возникает прерывание выполнения.
     */
    public void completeOrder() throws InterruptedException {
        homePage.setPriceRange(1000, 30000); //1
        homePage.selectProductWithColor("rgb(250, 250, 250)"); //2
        homePage.selectMemory("8"); //3
        homePage.selectProductCategory("Телефоны"); //4
        homePage.applyFilters(); //5
        homePage.addFirstProductToCart(); //6
        homePage.goToCart(); //7
        homePage.goToCartHeader(); //8
        cartPage.increaseProductQuantity(); //9
        cartPage.proceedToCheckout(); //10
        checkoutPage.selectPaymentMethod("Наличными при получении"); //11
        checkoutPage.selectDeliveryMethod("Самовывоз бесплатно"); //12
        checkoutPage.fillOrderForm( //13
                UserConfig.USER_NAME, UserConfig.USER_ADRESS, UserConfig.USER_PHONE, UserConfig.USER_EMAIL, UserConfig.USER_COMMENT);

        checkoutPage.proceedToOrder(); //14
    }
}