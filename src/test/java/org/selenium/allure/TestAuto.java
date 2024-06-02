package org.selenium.allure;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.selenium.allure.steps.StepDefinitions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;

/**
 * Класс TestAuto представляет автоматизированный тестовый сценарий.
 */
public class TestAuto {
    /**
     * Метод testOrderFlow выполняет тестирование потока заказа.
     *
     * @throws InterruptedException если возникает прерывание выполнения.
     */

    @Test
    public void testOrderFlow() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "D:\\Program Files\\webdrivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://algosstile.github.io/vue-app/index.html");

        StepDefinitions steps = new StepDefinitions(driver);
        steps.completeOrder();

        ((JavascriptExecutor) driver).executeScript("window.open()");//15
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        driver.get("https://www.google.ru/");

        /**
         * Явное ожидание загрузки поисковой строки для избежания возможных конфликтов
         * */
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement searchBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("q")));//16
        searchBox.sendKeys("Купить последнюю модель мобильного телефона Samsung за 100.000 руб");//17

        /**
         * Использование абсолютного XPath-локатора, не является хорошей практикой,
         * но в этом была острая необходимость).
         * */
        WebElement searchButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[4]/center/input[1]")));
        searchButton.click();

        driver.close();
        driver.switchTo().window(tabs.get(0));
        driver.quit();//18
    }
}
