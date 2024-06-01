package org.selenium.allure.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class GoogleSearchPage extends BasicPage {

    @FindBy(how = How.ID, using = "text")
    private WebElement searchInput;

    @FindBy(how = How.XPATH, using = "//button[@type='submit']")
    private WebElement searchButton;

    public GoogleSearchPage(WebDriver driver) {
        super(driver);
    }

    public void searchFor(String text) {
        searchInput.sendKeys(text);
        searchButton.click();
    }
}