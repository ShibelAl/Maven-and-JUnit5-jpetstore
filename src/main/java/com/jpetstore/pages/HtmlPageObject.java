package com.jpetstore.pages;
import com.jpetstore.util.Helper;
import com.jpetstore.util.LogHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.jpetstore.driver.DriverManager;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import static com.jpetstore.util.TimeUtil.getExplicitWait;
import java.time.Duration;
import java.util.List;


public class HtmlPageObject extends DriverManager {

    private final WebDriver driver = getDriver();

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


    /**
     * Method to enter text inside textbox
     */
    public void enterTextIntoTextBox(By by, String text) {
        WebElement textBox = findElementBy(by);
        textBox.clear();
        textBox.sendKeys(text);
        Helper.takeElementScreenShot(textBox, "textBox");

        LogHelper.logToReport("Typing text: " + text + " into text box with locator: " + textBox);
    }

    /**
     * Method to enter text inside textbox
     */
    public void enterTextIntoTextBox(WebElement element, String text) {
        element.clear();
        element.sendKeys(text);
        Helper.takeElementScreenShot(element, "textBox");

        LogHelper.logToReport("Typing text: " + text + " into text box with locator: " + element.toString());
    }

    /**
     * Method to return text form an element
     */
    public String getTextFromElement(By by) {
        WebElement element = findElementBy(by);
        return element.getText();
    }

    /**
     * Method to click on link or button
     */
    public void clickLinkOrBtn(By by) {
        WebElement element = findElementBy(by);
        element.click();
    }

    /**
     * Method to click on link or button
     */
    public void clickLinkOrBtnByElement(WebElement element) {
        element.click();
    }


    public String getDomAttribute(By by, String attribute) {
        WebElement element = findElementBy(by);
        return element.getDomAttribute(attribute);
    }

    public String getDomAttribute(WebElement element, String attribute) {
        return element.getDomAttribute(attribute);
    }

    public String getDomProperty(By by, String property) {
        WebElement element = findElementBy(by);
        return element.getDomProperty(property);
    }

    public String getDomProperty(WebElement element, String property) {
        return element.getDomProperty(property);
    }

    /**
     * Method to select by visible text.
     */
    public void selectByVisibleText(By by, String text) {
        WebElement element = findElementBy(by);
        Select select = new Select(element);
        select.selectByVisibleText(text);
    }

    /**
     * Method to select checkbox.
     */
    public boolean selectCheckBox(By by) {
        WebElement element = findElementBy(by);
        if(element.isSelected()) {
            return true;
        }
        element.click();
        return true;
    }

    /**
     * Method to select checkbox.
     */
    public boolean selectCheckBox(WebElement element) {
        if(element.isSelected()) {
            return true;
        }
        element.click();
        return true;
    }

    public boolean isTextPresentOnPage(String text) {
        String pageSource = driver.getPageSource();
        return pageSource != null && pageSource.contains(text);
    }

    /**
     * Method to select by index.
     */
    public void selectByIndex(By by, int index) {
        WebElement element = findElementBy(by);
        Select select = new Select(element);
        select.selectByIndex(index);
    }

    /**
     * Method to select by value.
     */
    public void selectByValue(By by, String value) {
        WebElement element = findElementBy(by);
        Select select = new Select(element);
        select.selectByValue(value);
    }
}
