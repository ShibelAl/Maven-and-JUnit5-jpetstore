package com.jpetstore.driver;

import com.jpetstore.util.Helper;
import com.jpetstore.util.PropKey;
import com.jpetstore.util.PropertyReader;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.firefox.FirefoxProfile;
import java.io.IOException;

public enum BrowserType implements DriverSetup{

    CHROME{
        @Override
        public Capabilities getBrowserCapabilities() {
            return getBrowserOptions();
        }

        @Override
        public ChromeOptions getBrowserOptions() {
            ChromeOptions options = new ChromeOptions();

            options.addArguments("start-maximized");
            options.addArguments("ignore-certificate-errors");
            options.addArguments("disable-infobars");
            options.addArguments("incognito");
            options.addArguments("window-size=1920,1080");
            options.setAcceptInsecureCerts(true);

            return options;
        }

        @Override
        public WebDriver getWebDriver() throws IOException {
            String browser_path = PropertyReader.getInstance().
                    getProperty(PropKey.CHROME_DRIVER_PATH.getPropVal());

            if(Helper.isWebDriverManager()){
                WebDriverManager.chromedriver().setup();
            }
            else{
                System.setProperty("webdriver.chrome.driver", browser_path);
            }

            ChromeOptions options = getBrowserOptions();
            return new ChromeDriver(options);
        }
    },
    FIREFOX{

        @Override
        public Capabilities getBrowserCapabilities() {
            return getBrowserOptions();
        }

        @Override
        public FirefoxOptions getBrowserOptions() {

            FirefoxOptions options = new FirefoxOptions();
            FirefoxProfile profile = new FirefoxProfile();

            profile.setAcceptUntrustedCertificates(true);
            profile.setAssumeUntrustedCertificateIssuer(false);

            options.setProfile(profile);

            return options;
        }

        @Override
        public WebDriver getWebDriver() throws IOException {
            String browser_path = PropertyReader.getInstance().
                    getProperty(PropKey.GECKO_DRIVER_PATH.getPropVal());

            if(Helper.isWebDriverManager()){
                WebDriverManager.chromedriver().setup();
            }
            else{
                System.setProperty("webdriver.gecko.driver", browser_path);
            }

            FirefoxOptions options = getBrowserOptions();
            return new FirefoxDriver(options);
        }
    }
}
