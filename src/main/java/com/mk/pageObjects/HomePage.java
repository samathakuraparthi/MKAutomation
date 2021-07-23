package com.mk.pageObjects;


import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import java.util.*;

public class HomePage extends BasePage {

    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//button[@class='countrySelector']")
    WebElement flag;

    @FindBy(xpath = "//span[@class='countrySelected']")
    WebElement selectedCountry;

    @FindBy(xpath = "//button[@class='close-button']")
    List<WebElement> closeWindowButton;

    @FindBy(xpath = "//div[@class='country-selector-panel']//h2")
    WebElement selectCountryPopup;

    @FindBy(xpath = "//button[@id='onetrust-accept-btn-handler']")
    List<WebElement> acceptAllCookiesButton;

    @FindBy(xpath = "//*[@aria-label='please select country to choose language']")
    List<WebElement> countriesList;

    public void acceptAllCookies() throws InterruptedException {
        Thread.sleep(5000);
        if (acceptAllCookiesButton.size() > 0) {
            acceptAllCookiesButton.get(0).click();
            Thread.sleep(3000);
        }
    }

    public void clickFlag() {
        waitForElementToBeClickable(driver, flag);
        flag.click();
    }

    public boolean isPopupDisplayed(String name) {

        return driver.findElement(By.xpath("//div[@class='country-selector-panel']//span[text()='" + name + "']")).isDisplayed();
    }

    public void displayCountryAndLanguages() {
        System.out.print("Following are the Countries with more than 1 Language\nCountries list with respective languages\n");
        for (WebElement country : countriesList) {
            List<WebElement> languages = driver.findElements(By.xpath("//*[@name='" + country.getText() + "']//ancestor::li[contains(@class,'country-selector-items')]//a[contains(@class,'multi-language')][1]"));
            if (languages.size() > 1) {
                System.out.print(country.getText() + " - ");
                for (WebElement language : languages) {
                    String lang = "(" + language.getAttribute("data-locale").split("_")[0].toUpperCase() + ")";
                    System.out.print(lang + " ");
                }
                System.out.println("\n");
            }
        }
    }

    public List<String> getCountriesForGivenRegion(String regionName) {
        List<WebElement> countriesList = driver.findElements(By.xpath("//button[text()='" + regionName + "']// ancestor::li[contains(@class,'country-region-items')]//div[contains(@class,'country-name')]//a"));
        List<String> countryValues = new ArrayList<String>();
        System.out.println("Size of List: " + countriesList.size());
        for (WebElement e : countriesList) {
            countryValues.add(e.getText());
        }
        return countryValues;
    }

    public void getCountryCurrencies(List<String> countriesList) throws InterruptedException {
        for (String country : countriesList) {
            Thread.sleep(2000);
            List<WebElement> languages = driver.findElements(By.xpath("//*[@name='" + country + "']//ancestor::li[contains(@class,'country-selector-items')]//a[contains(@class,'multi-language') and contains(text(),'(en)')][1]"));
            for (WebElement language : languages) {
                JavascriptExecutor executor = (JavascriptExecutor) driver;
                executor.executeScript("arguments[0].click();", language);
                Thread.sleep(3000);
                if (acceptAllCookiesButton.size() > 0) {
                    acceptAllCookies();
                }
                if (closeWindowButton.size() > 0) {
                    closeWindowButton.get(0).click();
                }
                System.out.println(selectedCountry.getText().replace(" ", "-"));
//                PrintStream out = new PrintStream(System.out, true, StandardCharsets.UTF_8);
//                out.println(selectedCountry.getText().replace(" ", "-"));
                clickFlag();
            }
        }
    }

    public boolean compareList(List<String> ls1, List<String> ls2) {
        //converts List into String and checks string are equal or not
        return ls1.toString().contentEquals(ls2.toString());
    }

    public List<String> getLanguagesForCountry(String countryName) {
        String languageElement = "//div[@name='" + countryName + "']//following-sibling:: div/ul/li[contains(@class,'multi-language-list-item')]";
        int noOfLanguages = driver.findElements(By.xpath(languageElement)).size();
        logger.info("Number of Languages for " + countryName + " are " + noOfLanguages);
        logger.info("Languages present for country " + countryName + " are :");
        List<String> languageList = new ArrayList<String>();
        for (int i = 1; i <= noOfLanguages; i++) {
            String language = driver.findElement(By.xpath("//div[@name='" + countryName + "']//following-sibling:: div/ul/li[" + i + "][contains(@class,'multi-language-list-item')]/a")).getAttribute("title");
            logger.info(language);
            languageList.add(language);
        }
        return languageList;
    }
}
