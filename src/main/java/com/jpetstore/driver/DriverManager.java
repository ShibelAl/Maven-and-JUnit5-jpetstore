package com.jpetstore.driver;

import com.jpetstore.util.PropertyReader;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

/**
 * Manages the WebDriver lifecycle for the application tests.
 * Extends {@link DriverFactory} to provide driver-related operations.
 */
public class DriverManager extends DriverFactory{

    /**
     * Initializes the WebDriver and loads properties before all tests.
     */
    @BeforeAll
    public static void setUp() {
        prop = PropertyReader.getInstance();
        driver = getDriver();
        driver.manage().window().maximize();
    }

    /**
     * Cleans up resources by quitting the WebDriver after all tests.
     */
    @AfterAll
    public static void tearDown(){
        driver = null;
        quitDriver();
    }

    /**
     * Deletes all cookies before each test method.
     */
    @BeforeEach
    public void beforeEachMethod() {
        getDriver().manage().deleteAllCookies();
    }
}
