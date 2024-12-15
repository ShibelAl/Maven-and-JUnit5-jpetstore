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


    @Step("Logging in with username: {0} & password: {1}")
    public void doLogin(String username, String password) {
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
    public AccountsPage addNewUserInformation(String userName, String password,
                                              String repeatPassword){

        return accountsPage.addNewUserInformation(userName,password,repeatPassword);
    }
}
