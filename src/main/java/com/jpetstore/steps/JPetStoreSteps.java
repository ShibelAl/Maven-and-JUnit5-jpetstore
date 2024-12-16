package com.jpetstore.steps;
import com.jpetstore.driver.DriverManager;
import com.jpetstore.pages.AccountsPage;
import com.jpetstore.pages.BasePage;
import com.jpetstore.pages.DashBoardPage;
import com.jpetstore.pages.LoginPage;
import io.qameta.allure.Step;

public class JPetStoreSteps extends DriverManager {

    private final BasePage basePage = new BasePage(getDriver());
    private final LoginPage loginPage = new LoginPage(getDriver());
    private final DashBoardPage dashBoardPage = new DashBoardPage(getDriver());
    private final AccountsPage accountsPage = new AccountsPage(getDriver());

    @Step("Navigating to JPetstore application")
    public void navigateToApp() {
        basePage.navigateToApp();
    }


    @Step("Navigating to Login Page")
    public void navigateToSignOnPage(){
        basePage.navigateToSignOnPage();
    }

    @Step("Navigating to user registration page")
    public void navigateToRegistrationPage() {

        loginPage.navigateToRegistrationPage();
    }

    @Step("Logging in with username: {0} & password: {1}")
    public void doLogin(String username, String password) {
        basePage.clickSignInLink();
        loginPage.doLogin(username, password);
    }

    @Step("Get greeting message")
    public String getGreetingMessage() {
        return dashBoardPage.getGreetingMessage();
    }

    @Step("Return message on invalid login")
    public String getMessageOnInvalidLogin(){
        return loginPage.getMessageOnInvalidLogin();
    }

    @Step("Adding new user information with userName: {0} , password: {1} , repeatPassword {2}")
    public void addNewUserInformation(String userName, String password,
                                      String repeatPassword){

        accountsPage.addNewUserInformation(userName, password, repeatPassword);
    }

    @Step("Adding account information- firstname:{0} , lastName:{1}," +
            " email:{2}, phone:{3}, addr1:{4}, addr2: {5}, city:{6}, "  +
            "state:{7}, zip:{8}, country:{9} ")
    public void addAccountInformation(String firstName ,
                                      String lastName ,
                                      String email ,
                                      String phone ,
                                      String addr1 ,
                                      String addr2 ,
                                      String city ,
                                      String state ,
                                      String zip ,
                                      String country) {


        accountsPage.addAccountInformation(firstName,
                lastName,
                email,
                phone,
                addr1,
                addr2,
                city,
                state,
                zip,
                country);
    }

    @Step("Adding profile information - language:{0} ,category: {1} ,myList: {2} ,myBanner:{3}")
    public void addProfileInformation(String language,
                                      String category ,
                                      boolean myList ,
                                      boolean myBanner) {

        accountsPage.addProfileInformation(language,
                category,
                myList,
                myBanner);
    }

    @Step("Saving account information")
    public void clickSaveAccountInformation() {

        accountsPage.clickSaveAccountInformation();
    }

}
