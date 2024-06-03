package org.selenium.allure.steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.selenium.allure.pages.CartPage;
import org.selenium.allure.pages.CheckoutPage;
import org.selenium.allure.pages.GoogleSearchPage;
import org.selenium.allure.pages.HomePage;

/**
 * Класс StepDefinitions содержит определения шагов для тестирования веб-сайта.
 * Он использует страницы HomePage, CheckoutPage, CartPage и GoogleSearchPage для выполнения действий.
 */
public class StepDefinitions {

    private final HomePage homePage;
    private final CheckoutPage checkoutPage;
    private final CartPage cartPage;
    private final GoogleSearchPage googleSearchPage;

    public StepDefinitions(WebDriver driver) {
        homePage = new HomePage(driver);
        checkoutPage = new CheckoutPage(driver);
        cartPage = new CartPage(driver);
        googleSearchPage = new GoogleSearchPage(driver);
    }

    /**
     * Установить диапазон цен и выбрать категорию продукта.
     *
     * @param minPrice Минимальная цена.
     * @param maxPrice Максимальная цена.
     * @param category Категория продукта.
     * @return Возвращает объект HomePage.
     */
    @Step("Set price range and select product category")
    public HomePage setPriceRangeAndSelectProductCategory(int minPrice, int maxPrice, String category) {
        homePage.setPriceRange(minPrice, maxPrice);
        homePage.selectProductCategory(category);
        homePage.selectProductWithColor("rgb(250, 250, 250");
        homePage.selectMemory("8");
        homePage.applyFilters();
        homePage.addFirstProductToCart();
        return homePage;
    }

    /**
     * Применить фильтры и добавить первый продукт в корзину.
     *
     * @return Возвращает объект CartPage.
     */
    @Step("Apply filters and add first product to cart")
    public CartPage applyFiltersAndAddFirstProductToCart() {
        cartPage.increaseProductQuantity();
        homePage.goToCart();
        homePage.goToCartHeader();
        cartPage.proceedToCheckout();
        return cartPage;
    }

    /**
     * Увеличить количество продукта и перейти к оформлению заказа.
     *
     * @return Возвращает объект CheckoutPage.
     */
    @Step("Increase product quantity and proceed to checkout")
    public CheckoutPage increaseProductQuantityAndProceedToCheckout() {
        cartPage.proceedToCheckout();
        return checkoutPage;
    }

    /**
     * Завершить процесс оформления заказа.
     *
     * @param paymentMethod  Способ оплаты.
     * @param deliveryMethod Способ доставки.
     * @return Возвращает объект CheckoutPage.
     */
    @Step("Complete order process")
    public CheckoutPage completeOrderProcess(String paymentMethod, String deliveryMethod) {
        checkoutPage.fillOrderForm();
        checkoutPage.selectPaymentMethod(paymentMethod);
        checkoutPage.selectDeliveryMethod(deliveryMethod);
        checkoutPage.proceedToOrder();
        return checkoutPage;
    }

    /**
     * Выполнить поиск по заданному запросу.
     *
     * @param query Запрос для поиска.
     * @return Возвращает объект GoogleSearchPage.
     */
    @Step("Search for {query}")
    public GoogleSearchPage search(String query) {
        googleSearchPage.openNewTab();
        googleSearchPage.searchFor(query);
        return googleSearchPage;
    }
}
