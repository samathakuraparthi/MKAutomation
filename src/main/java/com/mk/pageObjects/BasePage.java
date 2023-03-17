package com.mk.pageObjects;

import com.mk.managers.FileReaderManager;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;


public class BasePage {
   protected static final Logger logger = LoggerFactory.getLogger(BasePage.class);
    WebDriver driver;

    long time = FileReaderManager.getInstance().getConfigFileReader().getImplicitWait();


    public void waitForPageLoadComplete() {
        waitForPageLoadComplete(this.driver);
    }

    public void waitForPageLoadComplete(WebDriver driver) {
        ExpectedCondition<Boolean> pageLoadCondition = new
                ExpectedCondition<Boolean>() {
                    public Boolean apply(WebDriver driver) {
                        return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
                    }
                };
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(FileReaderManager.getInstance().getConfigFileReader().getFluentWait()))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(NoSuchElementException.class);
        wait.until(pageLoadCondition);
    }

    public void waitForElementToBeClickable(WebDriver driver, WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, (Duration.ofSeconds(time)));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitForVisibilityOfElement(WebDriver driver, WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, (Duration.ofSeconds(time)));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void scrollByVisibleElement(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
    }

    public void hoverOnElement(WebDriver driver, WebElement element) {
        Actions action = new Actions(driver);
        action.moveToElement(element).moveToElement(driver.findElement(By.xpath("/expression-here"))).click().build().perform();
    }

    public void pageRefresh() {
        driver.navigate().refresh();
        waitForPageLoadComplete();
    }
}
