package com.jpetstore.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import static com.jpetstore.util.Helper.getAppUrl;
import java.net.MalformedURLException;
import java.net.URL;


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


    /**
     * Navigate to app
     */
    public void navigateToApp() {

        try {
            driver.navigate().to(new URL(getAppUrl()));
        } catch (MalformedURLException e) {
            e.getCause();
        }
    }

    /**
     * Method to navigate to sign in page
     */
    public void navigateToSignOnPage(){
        clickLinkOrBtnByElement(enterTheStoreLink);
        clickLinkOrBtnByElement(signInLink);
        new LoginPage(driver);
    }

    /**
     * Clicks on Sign in link.
     * @return LoginPage instance.
     */
    public LoginPage clickSignInLink(){
        clickLinkOrBtn(By.xpath(SIGN_IN_LINK_XPATH));
        return new LoginPage(driver);
    }

    /**
     * Method to navigate to DashBoard.
     * @return DashBoardPage instance.
     */
    public DashBoardPage navigateToDashBoard(){
        clickLinkOrBtn(By.cssSelector(LOGO_LINK_CSS));
        return new DashBoardPage(driver);
    }

    /**
     * navigate to shopping cart.
     * @return ProductsPage instance.
     */
    public ProductsPage navigateToShoppingCart(){
        clickLinkOrBtn(By.cssSelector(SHOPPING_CART_LINK));
        return new ProductsPage(driver);
    }

    /**
     * Navigate to help page.
     * @return HelpPage instance.
     */
    public HelpPage navigateToHelpPage(){
        clickLinkOrBtn(By.xpath(HELP_LINK));
        return new HelpPage(driver);
    }

    /**
     * Method to search for a product
     * @param searchValue: a string that represents the search value.
     * @return ProductPage instance.
     */
    public ProductsPage searchForProduct(String searchValue){
        enterTextIntoTextBox(By.xpath(SEARCH_INPUT),searchValue);
        clickLinkOrBtn(By.xpath(SEARCH_BUTTON));
        return new ProductsPage(driver);
    }

    /**
     * Method to sign out.
     * @return DashBoardPage instance.
     */
    public DashBoardPage signOut(){
        clickLinkOrBtn(By.xpath(SIGN_OUT_LINK));
        return new DashBoardPage(driver);
    }

    /**
     * Navigate to accounts page.
     * @return AccountsPage instance.
     */
    public AccountsPage navigateToAccountPage(){
        clickLinkOrBtn(By.xpath(MY_ACCT_LINK));
        return new AccountsPage(driver);
    }

    /**
     * Method to select a product category from the header
     * @param productCategory: represents the categories of the pets in the application.
     * @return ProductPage instance.
     */
    public ProductsPage navigateToProductCategory(PetCategories productCategory){

        return switch (productCategory) {
            case FISH -> {
                clickLinkOrBtn(By.cssSelector(FISH_LINK));
                yield new ProductsPage(driver);
            }
            case DOGS -> {
                clickLinkOrBtn(By.cssSelector(DOGS_LINK));
                yield new ProductsPage(driver);
            }
            case REPTILES -> {
                clickLinkOrBtn(By.cssSelector(REPTILES_LINK));
                yield new ProductsPage(driver);
            }
            case CATS -> {
                clickLinkOrBtn(By.cssSelector(CATS_LINK));
                yield new ProductsPage(driver);
            }
            case BIRDS -> {
                clickLinkOrBtn(By.cssSelector(BIRDS_LINK));
                yield new ProductsPage(driver);
            }
        };
    }
}