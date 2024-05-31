package org.selenium.allure;


import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.selenium.allure.steps.StepDefinitions;

public class TestAuto {

    private static WebDriver driver;

    @Test
    public void testOrderFlow() {
        driver = new ChromeDriver();
        driver.get("https://algosstile.github.io/vue-app/index.html");

        StepDefinitions steps = new StepDefinitions(driver);
        steps.completeOrder();

        driver.get("https://ya.ru");

        driver.quit();
    }
}