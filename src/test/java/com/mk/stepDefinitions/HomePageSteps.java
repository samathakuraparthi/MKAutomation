package com.mk.stepDefinitions;

import com.mk.cucumber.TestContext;
import com.mk.pageObjects.HomePage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

import static org.junit.Assert.*;

import java.io.UnsupportedEncodingException;
import java.util.List;

public class HomePageSteps extends BaseSteps {
    HomePage homePage;
    public List<String> actualLanguageList;
    public List<String> countriesList;

    public HomePageSteps(TestContext context) {
        testContext = context;
        homePage = testContext.getPageObjectManager().getHomePage();
    }

    @Given("^user clicks on UK flag on homepage header$")
    public void clicksOnUKFlagOnHomepageHeader() throws InterruptedException {
        homePage.acceptAllCookies();
        Thread.sleep(3000);
        homePage.clickFlag();
    }

    @Then("^user gets and prints list of countries with more than one language$")
    public void userGetsListOfCountriesForAllRegions() {
        homePage.displayCountryAndLanguages();
    }

    @Then("^\"([^\"]*)\" popup is displayed$")
    public void popupIsDisplayed(String popupName) {
        assertTrue(homePage.isPopupDisplayed(popupName));
    }

    @When("^user gets list of countries for region \"([^\"]*)\"$")
    public void userGetsListOfCountriesForRegion(String regionName) {
        countriesList = homePage.getCountriesForGivenRegion(regionName);
    }

    @When("^user hovers on \"([^\"]*)\" under \"([^\"]*)\" region$")
    public void hoversOnCountry(String country, String region) {
        logger.info("Hovering on the region " + region);
        actualLanguageList = homePage.getLanguagesForCountry(country);

    }

    @Then("^List of Languages \"([^\"]*)\" for  the country \"([^\"]*)\" are displayed$")
    public void verifyLanguagesDisplayForARegion(List<String> listOfLanguages, String country) {
        Assert.assertTrue(homePage.compareList(listOfLanguages, actualLanguageList));
        System.out.println("List of Languages " + listOfLanguages + " are displayed for the " + country + " as expected");
    }

    @Then("^user prints currency for each country$")
    public void userPrintsCurrencyForEachCountry() {
        try {
            homePage.getCountryCurrencies(countriesList);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
