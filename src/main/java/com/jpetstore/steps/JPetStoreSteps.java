package com.jpetstore.steps;

import com.jpetstore.driver.DriverManager;
import com.jpetstore.pages.BasePage;
import com.jpetstore.pages.LoginPage;

public class JPetStoreSteps extends DriverManager {

    private BasePage basePage = new BasePage(getDriver());
    private LoginPage loginPage = new LoginPage(getDriver());

}
