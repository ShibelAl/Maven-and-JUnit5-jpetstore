package com.jpetstore.driver;

import com.jpetstore.util.PropKey;
import com.jpetstore.util.PropertyReader;
import org.openqa.selenium.WebDriver;
import java.io.IOException;
import static com.jpetstore.util.TimeUtil.getImplicitWait;

public class DriverFactory {

    public static PropertyReader prop;
    protected static WebDriver driver = null; // Retain driver for compatibility
    private static final ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();

    public static WebDriver getDriver() {
        if (driverThreadLocal.get() == null) {
            try {
                driverThreadLocal.set(getBrowser().getWebDriver());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        driver = driverThreadLocal.get(); // Keep driver synchronized with ThreadLocal
        driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(getImplicitWait()));
        return driver;
    }

    /**
     * Method to quit WebDriver
     */
    public static void quitDriver() {
        if (driverThreadLocal.get() != null) {
            driverThreadLocal.get().quit();
            driverThreadLocal.remove(); // Clean up ThreadLocal
        }
        driver = null; // Set driver to null for consistency
    }

    /**
     * Determine Browser
     * @return Browser type
     */
    private static BrowserType getBrowser() {
        String browser = prop.getProperty(PropKey.BROWSER.getPropVal());
        if (browser.equalsIgnoreCase("CHROME")) {
            return BrowserType.CHROME;
        } else if (browser.equalsIgnoreCase("FIREFOX")) {
            return BrowserType.FIREFOX;
        } else {
            return BrowserType.FIREFOX; // Default to Firefox
        }
    }
}
