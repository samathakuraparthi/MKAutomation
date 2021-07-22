package com.mk.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class ProductListPage extends BasePage {

    WebDriver driver;

    public ProductListPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@class='Price' or @class='salePrice']//span[@class='ada-link productAmount']")
    List<WebElement> priceList;

    @FindBy(xpath = "//a[text()='handbags']")
    WebElement handbagsLink;

    @FindBy(xpath = "//a[text()='View All Handbags']")
    WebElement viewAllHandbags;

    @FindBy(xpath = "//button[text()='Featured']")
    WebElement sortByDropdown;

    @FindBy(xpath = "//a[text()='price high to low']")
    WebElement hightoLowOption;

    public void navigateToHandbags() {
        Actions builder = new Actions(driver);
        builder.moveToElement(handbagsLink).build().perform();
        viewAllHandbags.click();
    }

    public void selectHighToLowOption() {
        sortByDropdown.click();
        hightoLowOption.click();
    }
}
