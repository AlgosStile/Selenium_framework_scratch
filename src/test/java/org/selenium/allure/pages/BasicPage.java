package org.selenium.allure.pages;

import org.openqa.selenium.WebDriver;

/**
 * Абстрактный класс BasicPage, представляющий базовую страницу.
 */
public abstract class BasicPage {

    /**
     * Веб-драйвер для взаимодействия с браузером.
     */
    protected WebDriver driver;

    /**
     * Конструктор класса BasicPage, принимающий веб-драйвер.
     *
     * @param driver Веб-драйвер для инициализации страницы.
     */
    public BasicPage(WebDriver driver) {
        this.driver = driver;
    }

}