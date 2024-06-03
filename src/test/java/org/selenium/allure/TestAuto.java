package org.selenium.allure;

import org.junit.jupiter.api.Test;
import org.selenium.allure.steps.StepDefinitions;

public class TestAuto extends BaseTest {

    @Test
    public void testOrderFlow() throws InterruptedException {
        driver.get("https://algosstile.github.io/vue-app/index.html");

        StepDefinitions steps = new StepDefinitions(driver);
        steps.completeOrder();
    }
}
