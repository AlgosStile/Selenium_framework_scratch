package org.selenium.allure.pages;

import org.openqa.selenium.WebDriver;

/**
 * Абстрактный класс BasicPage, представляющий базовую страницу.
 */
public abstract class BasicPage {
    protected WebDriver driver;

    public BasicPage(WebDriver driver) {
        this.driver = driver;
    }

}