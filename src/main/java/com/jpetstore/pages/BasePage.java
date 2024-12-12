package com.jpetstore.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.net.MalformedURLException;
import java.net.URL;

import static com.jpetstore.util.Helper.getAppUrl;

public class BasePage extends HtmlPageObject {

    private final WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

}