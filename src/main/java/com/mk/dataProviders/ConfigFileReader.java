package com.mk.dataProviders;

import com.mk.enums.DriverType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigFileReader {
    private static final Logger logger = LoggerFactory.getLogger(ConfigFileReader.class);

    private Properties config;
    public static long IMPLICIT_WAIT = 10;
    public static long EXPLICIT_WAIT = 20;
    public static long FLUENT_WAIT = 120;
    public static long PAGE_LOAD_TIMEOUT = 20;

    public ConfigFileReader() {
        config = new Properties();
        InputStream input = null;
        try {
            String filename = "config.properties";
            input = getClass().getClassLoader().getResourceAsStream(filename);
            if (input == null) {
                logger.info("Sorry, unable to find " + filename);
                return;
            }

            //load a properties file from class path, inside static method
            config.load(input);

        } catch (IOException ex) {
            logger.error(ex.getMessage());
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public String getProperty(String key) {
        return config.getProperty(key);
    }

    public String getProfile() {
        String profile = config.getProperty("profile");

        if (profile != null)
            return profile;
        else
            throw new RuntimeException("profile not specified in the config.properties file for the Key:profile");
    }

    public long getImplicitWait() {
        String implicitWait = config.getProperty("implicitWait");
        if (implicitWait != null) {
            try {
                return Long.parseLong(implicitWait);
            } catch (NumberFormatException e) {
                logger.error("Not able to parse implicitWait value : " + implicitWait + " in to Long");
            }
        }
        return IMPLICIT_WAIT;
    }


    public long getFluentWait() {
        String fluentWait = config.getProperty("fluentWait");
        if (fluentWait != null) {
            try {
                return Long.parseLong(fluentWait);
            } catch (NumberFormatException e) {
                logger.error("Not able to parse fluentWait value : " + fluentWait + " in to Long");
            }
        }
        return FLUENT_WAIT;
    }

    public String getApplicationUrl() {
        String url = config.getProperty("url");
        if (url != null)
            return url;
        else
            throw new RuntimeException("Application Url not specified in the Configuration.properties file for the Key:url");
    }

      public DriverType getBrowser() {
        String browserName = config.getProperty("browser");
        if (browserName == null || browserName.equals("chrome"))
            return DriverType.CHROME;
        else if (browserName.equalsIgnoreCase("firefox"))
            return DriverType.FIREFOX;
        else if (browserName.equals("iexplorer"))
            return DriverType.INTERNET_EXPLORER;
        else
            throw new RuntimeException(
                    "Browser Name Key value in Configuration.properties is not matched : " + browserName);
    }

}


