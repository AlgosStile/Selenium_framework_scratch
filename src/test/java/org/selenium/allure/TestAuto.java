package org.selenium.allure;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.selenium.allure.steps.StepDefinitions;

public class TestAuto extends BaseTest {
    @DisplayName("Test order flow - auto")
    @Test
    public void testOrderFlow() {
        driver.get("https://algosstile.github.io/vue-app/index.html");

        StepDefinitions steps = new StepDefinitions(driver);
        steps.setPriceRangeAndSelectProductCategory(1000, 30000, "Телефоны");
        steps.applyFiltersAndAddFirstProductToCart();
        steps.increaseProductQuantityAndProceedToCheckout();
        steps.completeOrderProcess("Наличными при получении", "Самовывоз бесплатно");
        steps.search("Купить последнюю модель мобильного телефона Samsung за 100.000 руб");

    }
}
