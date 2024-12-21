package com.jpetstore.util;
import com.jpetstore.driver.BrowserType;
import io.qameta.allure.Attachment;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;

import static org.apache.commons.lang3.SystemUtils.IS_OS_WINDOWS;


public class Helper {

    /**
     * Checks whether the browser manager is set to "webDriverManager".
     *
     * @return true if the browser manager is "webDriverManager", false otherwise.
     */
    public static boolean isWebDriverManager() {
        return PropertyReader.getInstance().getProperty(PropKey.BROWSER_MANAGER.getPropVal()).
                equalsIgnoreCase("webDriverManager");
    }

    /**
     * Retrieves the application URL by combining the base URL and port.
     *
     * @return the full application URL as a String.
     */
    public static String getAppUrl() {
        String baseUrl = PropertyReader.getInstance().getProperty(PropKey.URL.getPropVal());
        String port = PropertyReader.getInstance().getProperty(PropKey.PORT.getPropVal());
        return baseUrl + port;
    }

    /**
     * Takes a screenshot of the current state of the browser if screenshots are enabled.
     *
     * @param driver the WebDriver instance to capture the screenshot.
     * @param screenShotName the name to associate with the screenshot.
     * @return the screenshot as a byte array, or null if screenshots are disabled.
     */
    @Attachment(value = "{screenShotName}", type = "image/png")
    public static synchronized byte[] takeScreenShot(WebDriver driver, String screenShotName) {
        boolean isScreenShot = PropertyReader.getInstance()
                .getProperty(PropKey.SCREEN_SHOT.getPropVal())
                .equalsIgnoreCase("ENABLE");

        if (isScreenShot) {
            return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        }
        return null; // No screenshot taken
    }

    /**
     * Takes a screenshot of a specific web element if screenshots are enabled.
     *
     * @param element     the WebElement to capture in the screenshot.
     * @param elementName the name to associate with the screenshot.
     * @return the screenshot as a byte array, or null if screenshots are disabled.
     */
    @Attachment(value = "{elementName}", type = "image/png")
    public static synchronized byte[] takeElementScreenShot(WebElement element, String elementName) {
        String getElementScreenShot = SystemPropertyHelper.getElementScreenShotValue();

        if(getElementScreenShot.equalsIgnoreCase("ENABLE")) {
            return element.getScreenshotAs(OutputType.BYTES);
        }

        return null; // No screenshot taken
    }


    /**
     * This method checks if the tests will run on a remote webdriver
     * or a local webdriver (on localhost).
     * If REMOTE is ENABLE then the tests will run on a remote webdriver.
     */
    public static boolean isRemote(){

        return SystemPropertyHelper.getRemoteVal().equalsIgnoreCase("TRUE");
    }

    /**
     * Method to return hub url from property file.
     */
    public static String getHubUrl(){

        return SystemPropertyHelper.getHubUrl();
    }



    /**
     * Return the value of browserPath from property file
     */
    public static String getBrowserPath(){

        //  System.getProperty("os.name");

        if(IS_OS_WINDOWS){

            if(SystemPropertyHelper.getBrowserFromSystemVariable()
                    == BrowserType.CHROME){

                return PropertyReader.getInstance()
                        .getProperty(PropKey.CHROME_DRIVER_PATH_WIN.getPropVal());

            }else if(SystemPropertyHelper.getBrowserFromSystemVariable()
                    == BrowserType.FIREFOX){

                return PropertyReader.getInstance()
                        .getProperty(PropKey.GECKO_DRIVER_PATH_WIN.getPropVal());

            }
        }

        // If the OS is linux/mac
        if(SystemPropertyHelper.getBrowserFromSystemVariable() == BrowserType.CHROME){

            return PropertyReader.getInstance()
                    .getProperty(PropKey.CHROME_DRIVER_PATH_OSX.getPropVal());
        }else{
            return PropertyReader.getInstance()
                    .getProperty(PropKey.GECKO_DRIVER_PATH_OSX.getPropVal());
        }

    }

}
