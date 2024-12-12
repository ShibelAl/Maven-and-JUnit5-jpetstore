package com.jpetstore.driver;

import com.jpetstore.util.PropertyReader;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import java.io.IOException;

/**
 * Manages the WebDriver lifecycle for the application tests.
 * Extends {@link DriverFactory} to provide driver-related operations.
 */
public class DriverManager extends DriverFactory{

    /**
     * Initializes the WebDriver and loads properties before all tests.
     *
     * @throws IOException if there is an issue reading the properties file.
     */
    @BeforeAll
    public static void setUp() throws IOException {
        prop = PropertyReader.getInstance();
        driver = getDriver();
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
     *
     * @throws IOException if there is an issue interacting with the WebDriver.
     */
    @BeforeEach
    public void beforeEachMethod() throws IOException {
        getDriver().manage().deleteAllCookies();
    }
}
