package org.selenium.allure.pages;

import org.openqa.selenium.WebDriver;

/**
 * Абстрактный базовый класс для всех страниц.
 * Содержит основные методы и поля, общие для всех страниц.
 */
public abstract class BasicPage {
    protected WebDriver driver;

    /**
     * Конструктор для создания экземпляра страницы.
     *
     * @param driver Драйвер веб-браузера, который будет использоваться на странице.
     */
    public BasicPage(WebDriver driver) {
        this.driver = driver;
    }
}
