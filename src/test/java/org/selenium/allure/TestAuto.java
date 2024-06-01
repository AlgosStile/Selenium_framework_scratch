package org.selenium.allure;


import org.junit.jupiter.api.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.selenium.allure.steps.StepDefinitions;

import java.util.ArrayList;

public class TestAuto {

    private static WebDriver driver;

    @Test
    public void testOrderFlow() {
        driver = new ChromeDriver();
        driver.get("https://algosstile.github.io/vue-app/index.html");

        StepDefinitions steps = new StepDefinitions(driver);
        steps.completeOrder();

        ((JavascriptExecutor) driver).executeScript("window.open()");
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        driver.get("https://ya.ru");
        steps.searchOnYandex("купить последнюю модель samsung за 100000 руб");
        driver.close();

        driver.switchTo().window(tabs.get(0));
        driver.get("https://algosstile.github.io/vue-app/index.html");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.quit();
    }
}

