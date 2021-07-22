package com.mk.managers;

import com.mk.enums.DriverType;
import org.openqa.selenium.NoSuchSessionException;
import org.openqa.selenium.SessionNotCreatedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WebDriverManager {

    private static final Logger logger = LoggerFactory.getLogger(WebDriverManager.class);

    private WebDriver driver;
    private static DriverType driverType;


    public WebDriverManager() {
        driverType = FileReadManager.getInstance().getConfigFileReader().getBrowser();
    }

    public WebDriver getDriver() {
        logger.debug("----- get Driver()---------");
        if (driver == null)
            driver = createDriver();
        return driver;
    }

    private WebDriver createDriver() {
        driver = createLocalDriver();
        return driver;
    }

    private WebDriver createLocalDriver() {
        logger.debug("------- Create Local Driver()------ driverType :" + driverType.toString());

        switch (driverType) {
            case FIREFOX:
                io.github.bonigarcia.wdm.WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case CHROME:
                try {
                    ChromeOptions options = new ChromeOptions();
                    options.addArguments("start-maximized");
                    io.github.bonigarcia.wdm.WebDriverManager.chromedriver().browserVersion("72.0.3626.6").setup();
                    driver = new ChromeDriver(options);
                } catch (Exception e) {
                    logger.error("-------- Error Occured while getting chrome------" + e.getMessage());
                }
                break;
            case INTERNET_EXPLORER:
                io.github.bonigarcia.wdm.WebDriverManager.iedriver().setup();
                driver = new InternetExplorerDriver();
                break;
        }
        driver.get(FileReadManager.getInstance().getConfigFileReader().getApplicationUrl());
        driver.manage().window().maximize();
        return driver;
    }

    public void closeDriver() {
        logger.debug("---- closing Web driver------");
        if (driver != null) {
            try {
                driver.manage().deleteAllCookies();
                driver.close();
                driver.quit();
            } catch (NoSuchMethodError nsme) {// in case quit fails
                logger.error(nsme.getMessage());
            } catch (NoSuchSessionException nsse) {// in case close fails
                logger.error(nsse.getMessage());
            }catch (SessionNotCreatedException snce){ // in case close
                logger.error(snce.getMessage());
            }
            driver= null;

        }
    }
}
