package com.jpetstore.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class AccountsPage extends BasePage {

    public AccountsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    private static final String USER_NAME_INPUT = "//*[@id='Catalog']//input[@name='username']";

    private static final String PASSWORD_INPUT = "//*[@id='Catalog']//input[@name='password']";

    private static final String REAPEATED_PASSWORD_INPUT = "//*[@id='Catalog']//input[@name='repeatedPassword']";

    private static final String FIRST_NAME_INPUT = "//*[@id='Catalog']//input[@name='account.firstName']";

    private static final String LAST_NAME_INPUT = "//*[@id='Catalog']//input[@name='account.lastName']";

    private static final String EMAIL_INPUT = "//*[@id='Catalog']//input[@name='account.email']";

    private static final String PHONE_INPUT = "//*[@id='Catalog']//input[@name='account.phone']";

    private static final String ADDR1_INPUT = "//*[@id='Catalog']//input[@name='account.address1']";

    private static final String ADDR2_INPUT = "//*[@id='Catalog']//input[@name='account.address2']";

    private static final String CITY_INPUT = "//*[@id='Catalog']//input[@name='account.city']";

    private static final String STATE_INPUT = "//*[@id='Catalog']//input[@name='account.state']";

    private static final String ZIP_INPUT = "//*[@id='Catalog']//input[@name='account.zip']";

    private static final String COUNTRY_INPUT = "//*[@id='Catalog']//input[@name='account.country']";

    private static final String LANGUAGE_PREFERENCE_DROPDOWN = "//*[@id='Catalog']//select[@name='account.languagePreference']";

    private static final String FAVOURITE_CATEGORY_DROPDOWN = "//*[@id='Catalog']//select[@name='account.favouriteCategoryId']";

    private static final String ENABLE_MY_LIST_CHECKBOX = "//*[@id='Catalog']//input[@name='account.listOption']";

    private static final String ENABLE_BANNER_CHECKBOX = "//*[@id='Catalog']//input[@name='account.bannerOption']";

    private static final String SAVE_ACCT_INFO_BUTTON = "//*[@id='Catalog']//input[@value='Save Account Information']";

}
