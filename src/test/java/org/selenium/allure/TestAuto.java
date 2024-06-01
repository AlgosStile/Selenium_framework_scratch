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

        driver.get("https://ya.ru");

        driver.quit();
    }

    @Test
    public void testYandexSearch() {
        // Открытие нового окна
        ((JavascriptExecutor)driver).executeScript("window.open()");
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));

        // Поиск Яндексе
        driver.get("https://ya.ru");
        StepDefinitions steps = new StepDefinitions(driver);
        steps.searchOnYandex("купить последнюю модель samsung за 100000 руб");

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.quit();
    }

}