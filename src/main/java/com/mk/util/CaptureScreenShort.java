package com.mk.util;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;

public class CaptureScreenShort {
   public static void takeScreenshot(WebDriver driver, String scenarioName, String status) {
        try {
            // To create reference of TakesScreenshot
            TakesScreenshot screenshot = (TakesScreenshot) driver;
            // Call method to capture screenshot
            File src = screenshot.getScreenshotAs(OutputType.FILE);
            // Copy files to specific location
            // result.getName() will return name of test case so that screenshot name will
            // be same as test case name
            if (status.equals("FAILURE")) {
                FileUtils.copyFile(src, new File("./ScreenshotsFailure/" + scenarioName + ".png"));
            }
            System.out.println("Printing screen shot taken for classname " + scenarioName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
