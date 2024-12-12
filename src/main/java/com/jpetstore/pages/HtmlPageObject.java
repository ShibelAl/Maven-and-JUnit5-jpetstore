package com.jpetstore.pages;

import com.jpetstore.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import static com.jpetstore.util.TimeUtil.getExplicitWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.IOException;
import java.time.Duration;
import java.util.List;


public class HtmlPageObject extends DriverManager {

    private final WebDriver driver = getDriver();

    public HtmlPageObject() throws IOException {

    }

    /**
     * Method to find element by css selector.
     */
    public WebElement findElementByCssSelector(String cssSelector) {
        try {
            By by = By.cssSelector(cssSelector);
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(getExplicitWait()));

            return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        }
        catch (TimeoutException t) {
            throw new TimeoutException();
        }
    }


    /**
     * Method to find element by xpath.
     */
    public WebElement findElementByXpath(String xpathLocator) {
        try {
            By by = By.xpath(xpathLocator);
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(getExplicitWait()));

            return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        }
        catch (TimeoutException t) {
            throw new TimeoutException();
        }
    }


    /**
     * Method to find element by id.
     */
    public WebElement findElementById(String idLocator) {
        try {
            By by = By.id(idLocator);
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(getExplicitWait()));

            return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        }
        catch (TimeoutException t) {
            throw new TimeoutException();
        }
    }


    /**
     * Method to find an element by using By locator.
     */
    public WebElement findElementBy(By by) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(getExplicitWait()));

            return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        }
        catch (TimeoutException t) {
            throw new TimeoutException();
        }
    }


    /**
     * Method to find an element by using By locator.
     */
    public List<WebElement> findElementsBy(By by) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(getExplicitWait()));

            return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
        }
        catch (TimeoutException t) {
            throw new TimeoutException();
        }
    }
}
