package com.jpetstore.util;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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
     * @return true if the screenshot was taken, false otherwise.
     */
    @Attachment(value = "{screenShotName}", type = "image/png")
    public static synchronized boolean takeScreenShot(WebDriver driver, String screenShotName) {
        boolean isScreenShot = PropertyReader.getInstance()
                .getProperty(PropKey.SCREEN_SHOT.getPropVal())
                .equalsIgnoreCase("ENABLE");

        if (isScreenShot) {
            attachScreenShot(driver, screenShotName);
            return true;
        }
        return false;
    }

    /**
     * Captures and attaches a screenshot to the report.
     *
     * @param driver the WebDriver instance to capture the screenshot.
     * @param name the name to associate with the screenshot.
     * @return the screenshot as a byte array.
     */
    @Attachment(value = "{name}", type = "image/png")
    private static synchronized byte[] attachScreenShot(WebDriver driver, String name) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    /**
     * Takes a screenshot of a specific web element if screenshots are enabled.
     *
     * @param element the WebElement to capture in the screenshot.
     * @param name the name to associate with the screenshot.
     * @return true if the screenshot was taken, false otherwise.
     */
    public static synchronized boolean takeElementScreenShot(WebElement element, String name) {
        boolean isScreenShot = PropertyReader.getInstance()
                .getProperty(PropKey.SCREEN_SHOT.getPropVal())
                .equalsIgnoreCase("ENABLE");

        if (isScreenShot) {
            attachElementScreenShot(element, name);
            return true;
        }
        return false;
    }

    /**
     * Captures and attaches a screenshot of a specific web element to the report.
     *
     * @param element the WebElement to capture in the screenshot.
     * @param name the name to associate with the screenshot.
     * @return the screenshot of the element as a byte array.
     */
    @Attachment(value = "{name}", type = "image/png")
    private static synchronized byte[] attachElementScreenShot(WebElement element, String name) {
        return element.getScreenshotAs(OutputType.BYTES);
    }

}
