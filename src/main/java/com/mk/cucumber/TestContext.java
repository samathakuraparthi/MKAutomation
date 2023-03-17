package com.mk.cucumber;

import com.mk.managers.PageObjectManager;
import com.mk.managers.WebDriverManager;



public class TestContext {
    private final WebDriverManager webDriverManager;
    private final PageObjectManager pageObjectManager;

    public TestContext(){
        webDriverManager = new WebDriverManager();
        pageObjectManager = new PageObjectManager(webDriverManager.getDriver());
    }

    public WebDriverManager getWebDriverManager(){ return webDriverManager;}

    public PageObjectManager getPageObjectManager(){ return pageObjectManager;}
}
