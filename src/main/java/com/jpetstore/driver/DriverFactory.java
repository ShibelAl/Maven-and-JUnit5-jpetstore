package com.jpetstore.driver;

import com.jpetstore.util.PropKey;
import com.jpetstore.util.PropertyReader;
import org.openqa.selenium.WebDriver;
import java.io.IOException;
import static com.jpetstore.util.TimeUtil.getImplicitWait;

public class DriverFactory {

    public static PropertyReader prop;
    protected static WebDriver driver = null;
    private static final ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();

    public static WebDriver getDriver() throws IOException {
        if(driver == null) {
            driverThreadLocal.set(getBrowser().getWebDriver());
        }
        driverThreadLocal.get().manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(getImplicitWait()));
        return driverThreadLocal.get();
    }

    /**
     * Method to quit WebDriver
     */
    public static void quitDriver() {
        if(driver != null) {
            driverThreadLocal.get().quit();
        }
    }

    /**
     * Determine Browser
     * @return Browser type
     */
    private static BrowserType getBrowser() throws IOException {

        if(prop.getProperty(PropKey.BROWSER.getPropVal()).equalsIgnoreCase("CHROME")){
            return BrowserType.CHROME;
        }
        else if(prop.getProperty(PropKey.BROWSER.getPropVal()).equalsIgnoreCase("FIREFOX")){
            return BrowserType.FIREFOX;
        }
        else return BrowserType.FIREFOX;
    }
}
