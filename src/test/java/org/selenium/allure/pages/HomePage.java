package org.selenium.allure.pages;

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

    @FindBy(how = How.ID, using = "color")
    private WebElement colorSelect;

    @FindBy(how = How.ID, using = "memory")
    private WebElement memorySelect;

    @FindBy(how = How.XPATH, using = "//button[text()='Применить']")
    private WebElement applyButton;

    @FindBy(how = How.XPATH, using = "//div[@class='product']//button[text()='В корзину']")
    private WebElement addToCartButton;

    @FindBy(how = How.ID, using = "cart")
    private WebElement cartButton;

    @FindBy(how = How.ID, using = "submit")
    private WebElement submitButton;


    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void selectProductCategory(String category) {
        new Select(productCategory).selectByVisibleText(category);
    }

    public void setPriceRange(int minPrice, int maxPrice) {
        minPriceInput.clear();
        minPriceInput.sendKeys(String.valueOf(minPrice));
        maxPriceInput.clear();
        maxPriceInput.sendKeys(String.valueOf(maxPrice));
    }

    public void selectColor(String color) {
        new Select(colorSelect).selectByVisibleText(color);
    }

    public void selectMemory(String memory) {
        new Select(memorySelect).selectByVisibleText(memory);
    }

    public void applyFilters() {
        applyButton.click();
    }

    public void submitOrder() {
        submitButton.click();
    }
    public void addFirstProductToCart() {
        addToCartButton.click();
    }

    public void goToCart() {
        cartButton.click();
    }
}