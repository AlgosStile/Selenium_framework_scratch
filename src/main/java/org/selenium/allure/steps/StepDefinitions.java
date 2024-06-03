//package org.selenium.allure.steps;
//
//import io.qameta.allure.Step;
//import org.openqa.selenium.WebDriver;
//import org.selenium.allure.pages.CartPage;
//import org.selenium.allure.pages.CheckoutPage;
//import org.selenium.allure.pages.HomePage;
//
///**
// * Класс StepDefinitions содержит шаги для автоматизированного тестирования сценариев.
// */
//public class StepDefinitions {
//
//    private final HomePage homePage;
//    private final CheckoutPage checkoutPage;
//    private final CartPage cartPage;
//
//
//    public StepDefinitions(WebDriver driver) {
//        homePage = new HomePage(driver);
//        checkoutPage = new CheckoutPage(driver);
//        cartPage = new CartPage(driver);
//    }
//
//    @Step("Complete order")
//    public CheckoutPage completeOrder() throws InterruptedException {
//        homePage.setPriceRange(1000, 30000);
//        homePage.selectProductWithColor("rgb(250, 250, 250");
//        homePage.selectMemory("8");
//        homePage.selectProductCategory("Телефоны");
//        homePage.applyFilters();
//        homePage.addFirstProductToCart();
//        homePage.goToCart();
//        homePage.goToCartHeader();
//        cartPage.increaseProductQuantity();
//        cartPage.proceedToCheckout();
//        checkoutPage.selectPaymentMethod("Наличными при получении");
//        checkoutPage.selectDeliveryMethod("Самовывоз бесплатно");
//        checkoutPage.fillOrderForm();
//        checkoutPage.proceedToOrder();
//        return checkoutPage;
//    }
//}
package org.selenium.allure.steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.selenium.allure.pages.CartPage;
import org.selenium.allure.pages.CheckoutPage;
import org.selenium.allure.pages.GoogleSearchPage;
import org.selenium.allure.pages.HomePage;

/**
 * Класс StepDefinitions содержит шаги для автоматизированного тестирования сценариев.
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

    @Step("Apply filters and add first product to cart")
    public CartPage applyFiltersAndAddFirstProductToCart() {
        cartPage.increaseProductQuantity();
        homePage.goToCart();
        homePage.goToCartHeader();
        cartPage.proceedToCheckout();
        return cartPage;
    }

    @Step("Increase product quantity and proceed to checkout")
    public CheckoutPage increaseProductQuantityAndProceedToCheckout() {
        cartPage.proceedToCheckout();
        return checkoutPage;
    }

    @Step("Complete order process")
    public CheckoutPage completeOrderProcess(String paymentMethod, String deliveryMethod) {
        checkoutPage.fillOrderForm();
        checkoutPage.selectPaymentMethod(paymentMethod);
        checkoutPage.selectDeliveryMethod(deliveryMethod);
        checkoutPage.proceedToOrder();
        return checkoutPage;
    }

    @Step("Search for {query}")
    public GoogleSearchPage search(String query) {
        googleSearchPage.openNewTab();
        googleSearchPage.searchFor(query);
        return googleSearchPage;
    }
}
