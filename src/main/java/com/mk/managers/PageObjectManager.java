package com.mk.managers;

import com.mk.pageObjects.*;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PageObjectManager {
    private static final Logger logger = LoggerFactory.getLogger(PageObjectManager.class);

    private WebDriver driver;

    private HomePage homePage;

    public PageObjectManager(WebDriver driver) {
        this.driver = driver;
    }

    public HomePage getHomePage() {
        return (homePage == null) ? homePage = new HomePage(driver) : homePage;
    }
}

