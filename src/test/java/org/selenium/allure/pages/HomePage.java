package org.selenium.allure.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class HomePage extends BasicPage {

    @FindBy(how = How.ID, using = "product-category")
    private WebElement productCategory;

    @FindBy(how = How.NAME, using = "min-price")
    private WebElement minPriceInput;

    @FindBy(how = How.NAME, using = "max-price")
    private WebElement maxPriceInput;

    @FindBy(how = How.XPATH, using = "//button[text()='Применить']")
    private WebElement applyButton;

    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void selectProductCategory(String category) {
        Select dropdown = new Select(driver.findElement(By.cssSelector("select[name='category']")));
        dropdown.selectByVisibleText(category);
    }

    public void setPriceRange(int minPrice, int maxPrice) {
        minPriceInput.clear();
        minPriceInput.sendKeys(String.valueOf(minPrice));
        maxPriceInput.clear();
        maxPriceInput.sendKeys(String.valueOf(maxPrice));
    }

    public void selectProductWithColor(String colorValue) {
        WebElement colorPicker = driver.findElement(By.xpath("//label[contains(@class, 'colors__label')]//span[contains(@style, 'rgb(250, 250, 250)')]"));
        colorPicker.click();
    }

    public void selectMemory(String memory) {
        String checkboxSelector = "input[type='checkbox'][name='volume'][value='" + memory + "']";
        WebElement memoryCheckbox = driver.findElement(By.cssSelector(checkboxSelector));
        if (!memoryCheckbox.isSelected()) {
            memoryCheckbox.click();
        }
    }


    public void applyFilters() {
        applyButton.click();
    }

    public void addFirstProductToCart() {
        WebElement firstProductLink = driver.findElement(By.cssSelector("li.catalog__item a.catalog__pic"));
        firstProductLink.click();
    }


    public void goToCart() {
        WebElement cartButton = driver.findElement(By.cssSelector("button.button--primery"));
        cartButton.click();
    }

    public void goToCartHeader() {
        WebElement cartIcon = driver.findElement(By.cssSelector("a.header__cart"));
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", cartIcon);
    }

}