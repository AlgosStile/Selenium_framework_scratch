package org.selenium.allure.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * Класс GoogleSearchPage представляет страницу поиска в Google.
 */
public class GoogleSearchPage extends BasicPage {

    @FindBy(how = How.ID, using = "text")
    private WebElement searchInput;

    @FindBy(how = How.XPATH, using = "//button[@type='submit']")
    private WebElement searchButton;

    /**
     * Конструктор класса GoogleSearchPage, принимающий веб-драйвер.
     *
     * @param driver Веб-драйвер для инициализации страницы поиска Google.
     */
    public GoogleSearchPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Выполняет поиск указанного текста.
     *
     * @param text Текст для поиска.
     */
    public void searchFor(String text) {
        searchInput.sendKeys(text);
        searchButton.click();
    }
}