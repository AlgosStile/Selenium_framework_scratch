package org.selenium.allure.steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
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
     * Выполняет полный цикл заказа.
     *
     * @return Объект страницы CheckoutPage после завершения заказа.
     * @throws InterruptedException Если происходит прерывание потока.
     */
    @Step("Complete order")
    public CheckoutPage completeOrder() throws InterruptedException {
        homePage.setPriceRange(1000, 30000);
        homePage.selectProductWithColor("rgb(250, 250, 250");
        homePage.selectMemory("8");
        homePage.selectProductCategory("Телефоны");
        homePage.applyFilters();
        homePage.addFirstProductToCart();
        homePage.goToCart();
        homePage.goToCartHeader();
        cartPage.increaseProductQuantity();
        cartPage.proceedToCheckout();
        checkoutPage.selectPaymentMethod("Наличными при получении");
        checkoutPage.selectDeliveryMethod("Самовывоз бесплатно");
        checkoutPage.fillOrderForm();
        checkoutPage.proceedToOrder();
        return checkoutPage;
    }
}
