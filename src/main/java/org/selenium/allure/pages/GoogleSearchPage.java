package org.selenium.allure.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;

public class GoogleSearchPage extends BasicPage {

    @FindBy(how = How.NAME, using = "q")
    private WebElement searchInput;

    public GoogleSearchPage(WebDriver driver) {
        super(driver);
    }

    public void openNewTab() {
        ((JavascriptExecutor) driver).executeScript("window.open()");
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        driver.get("https://www.google.ru/");
    }

    public void searchFor(String text) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement searchBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("q")));
        searchBox.sendKeys(text);

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//ul")));
        searchBox.submit();
    }
}
