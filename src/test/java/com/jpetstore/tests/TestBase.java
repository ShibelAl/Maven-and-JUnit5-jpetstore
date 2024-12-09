package com.jpetstore.tests;
import com.jpetstore.util.PropertyReader;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestBase {
    static WebDriver driver;
    static PropertyReader prop = PropertyReader.getInstance();

    @BeforeAll
    public static void init(){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/windows/chromedriver.exe");
        driver = new ChromeDriver();
    }

    @AfterAll
    public static void cleanUp(){
        driver.quit();
    }
}
