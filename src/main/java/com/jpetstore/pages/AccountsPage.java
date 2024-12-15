package com.jpetstore.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.jpetstore.driver.DriverFactory;
import org.openqa.selenium.support.PageFactory;

public class AccountsPage extends BasePage {

    public AccountsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    private static final String USER_NAME_INPUT = "//*[@id='Catalog']//input[@name='username']";

    private static final String PASSWORD_INPUT = "//*[@id='Catalog']//input[@name='password']";

    private static final String REPEATED_PASSWORD_INPUT = "//*[@id='Catalog']//input[@name='repeatedPassword']";

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


    /**
     *
     * @param userName: the username of the user.
     * @param password: the password of the user.
     * @param repeatPassword: the password of the user, in the repeat password field.
     * @return AccountsPage instance.
     */
    public AccountsPage addNewUserInformation(String userName,String password,
                                              String repeatPassword){

        enterTextIntoTextBox(By.xpath(USER_NAME_INPUT),userName);
        enterTextIntoTextBox(By.xpath(PASSWORD_INPUT),password);
        enterTextIntoTextBox(By.xpath(REPEATED_PASSWORD_INPUT),repeatPassword);

        return this;
    }


    /**
     * Method to enter account info
     */
    public AccountsPage addAccountInformation(String firstName,
                                              String lastName,
                                              String email,
                                              String phone ,
                                              String addr1 ,
                                              String addr2 ,
                                              String city ,
                                              String state ,
                                              String zip ,
                                              String country){

        enterTextIntoTextBox(By.xpath(FIRST_NAME_INPUT),firstName);
        enterTextIntoTextBox(By.xpath(LAST_NAME_INPUT),lastName);
        enterTextIntoTextBox(By.xpath(EMAIL_INPUT),email);
        enterTextIntoTextBox(By.xpath(PHONE_INPUT),phone);
        enterTextIntoTextBox(By.xpath(ADDR1_INPUT),addr1);
        enterTextIntoTextBox(By.xpath(ADDR2_INPUT),addr2);
        enterTextIntoTextBox(By.xpath(CITY_INPUT),city);
        enterTextIntoTextBox(By.xpath(STATE_INPUT),state);
        enterTextIntoTextBox(By.xpath(ZIP_INPUT),zip);
        enterTextIntoTextBox(By.xpath(COUNTRY_INPUT),country);

        return this;
    }

    /**
     * Method to add profile information.
     */
    public AccountsPage addProfileInformation(String language,
                                              String category,
                                              boolean myList,
                                              boolean myBanner){

        selectByVisibleText(By.xpath(LANGUAGE_PREFERENCE_DROPDOWN),language);

        selectByVisibleText(By.xpath(FAVOURITE_CATEGORY_DROPDOWN),category);

        selectCheckBox(By.xpath(ENABLE_MY_LIST_CHECKBOX));

        selectCheckBox(By.xpath(ENABLE_BANNER_CHECKBOX));

        return this;
    }

    /**
     * Saving account info
     */
    public DashBoardPage clickSaveAccountInformation(){

        clickLinkOrBtn(By.xpath(SAVE_ACCT_INFO_BUTTON));
        return new DashBoardPage(DriverFactory.driver);
    }

}
