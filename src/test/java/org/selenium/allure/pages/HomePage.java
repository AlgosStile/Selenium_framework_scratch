package org.selenium.allure.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

/**
 * Класс HomePage представляет домашнюю страницу магазина.
 */
public class HomePage extends BasicPage {

    @FindBy(how = How.NAME, using = "min-price")
    private WebElement minPriceInput;

    @FindBy(how = How.NAME, using = "max-price")
    private WebElement maxPriceInput;

    @FindBy(how = How.XPATH, using = "//button[text()='Применить']")
    private WebElement applyButton;

    /**
     * Конструктор класса HomePage, принимающий веб-драйвер.
     *
     * @param driver Веб-драйвер для инициализации домашней страницы магазина.
     */
    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    /**
     * Выбирает категорию продукта.
     *
     * @param category Название категории продукта.
     */
    public void selectProductCategory(String category) {
        Select dropdown = new Select(driver.findElement(By.cssSelector("select[name='category']")));
        dropdown.selectByVisibleText(category);
    }

    /**
     * Устанавливает диапазон цен для продуктов.
     *
     * @param minPrice Минимальная цена.
     * @param maxPrice Максимальная цена.
     */
    public void setPriceRange(int minPrice, int maxPrice) {
        minPriceInput.clear();
        minPriceInput.sendKeys(String.valueOf(minPrice));
        maxPriceInput.clear();
        maxPriceInput.sendKeys(String.valueOf(maxPrice));
    }

    /**
     * Выбирает продукт по цвету.
     *
     * @param colorValue Значение цвета продукта.
     */
    public void selectProductWithColor(String colorValue) {
        WebElement colorPicker = driver.findElement(By.xpath("//span[contains(@style, '250,')]"));
        colorPicker.click();
    }

    /**
     * Выбирает память продукта.
     *
     * @param memory Значение памяти продукта.
     */
    public void selectMemory(String memory) {
        String checkboxSelector = "input[type='checkbox'][name='volume'][value='" + memory + "']";
        WebElement memoryCheckbox = driver.findElement(By.cssSelector(checkboxSelector));
        if (!memoryCheckbox.isSelected()) {
            memoryCheckbox.click();
        }
    }

    /**
     * Применяет выбранные фильтры.
     */
    public void applyFilters() {
        applyButton.click();
    }

    /**
     * Добавляет первый продукт в корзину.
     */
    public void addFirstProductToCart() {
        WebElement firstProductLink = driver.findElement(By.cssSelector("li.catalog__item a.catalog__pic"));
        firstProductLink.click();
    }

    /**
     * Переходит в корзину.
     */
    public void goToCart() {
        WebElement cartButton = driver.findElement(By.cssSelector("button.button--primery"));
        cartButton.click();
    }

    /**
     * Переходит в корзину через иконку корзины в шапке страницы.
     */
    public void goToCartHeader() {
        WebElement cartIcon = driver.findElement(By.cssSelector("a.header__cart"));
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", cartIcon);
    }

}