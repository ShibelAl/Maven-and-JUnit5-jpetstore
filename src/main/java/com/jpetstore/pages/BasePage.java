package com.jpetstore.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class BasePage extends HtmlPageObject {

    private final WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    private static final String ENTER_THE_STORE_LINK_XPATH = "//a[@href='actions/Catalog.action']";

    private static final String SIGN_IN_LINK_XPATH = "//*[@id='MenuContent']/a[contains(text(),'Sign In')]";

    private static final String LOGO_LINK_CSS = "div[id='LogoContent'] a[href$='.action']";

    private static final String SIGN_OUT_LINK = "//*[@id='MenuContent']/a[contains(text(),'Sign Out')]";

    private static final String MY_ACCT_LINK = "//*[@id='MenuContent']/a[contains(text(),'My Account')]";

    private static final String HELP_LINK = "//*[@id='MenuContent']/a[contains(text(),'?')]";

    private static final String SHOPPING_CART_LINK = "div[id='MenuContent'] a[href$='?viewCart=']";

    private static final String SEARCH_INPUT = "//input[@name='keyword']";

    private static final String SEARCH_BUTTON = "//input[@value='Search']";

    // Product Quick Links
    private static final String FISH_LINK = "div[id='QuickLinks'] a[href$='FISH']";

    private static final String DOGS_LINK = "div[id='QuickLinks'] a[href$='DOGS']";

    private static final String REPTILES_LINK = "div[id='QuickLinks'] a[href$='REPTILES']";

    private static final String CATS_LINK = "div[id='QuickLinks'] a[href$='CATS']";

    private static final String BIRDS_LINK = "div[id='QuickLinks'] a[href$='BIRDS']";

    private static final String BANNER_IMG = "//*[@id='Banner']/img";

    @FindBy(xpath = ENTER_THE_STORE_LINK_XPATH)
    private WebElement enterTheStoreLink;

    @FindBy(xpath = SIGN_IN_LINK_XPATH)
    private WebElement signInLink;

}