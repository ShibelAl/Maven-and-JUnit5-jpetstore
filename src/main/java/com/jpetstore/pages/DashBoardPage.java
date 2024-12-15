package com.jpetstore.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashBoardPage extends BasePage{

    public DashBoardPage(WebDriver driver) {
        super(driver);
    }

    private static final String GREETING_MSG = "//*[@id='WelcomeContent']";

    /**
     * Get greeting message.
     * @return the greeting message after logging in to the website.
     */
    public String getGreetingMessage(){
        return getTextFromElement(By.xpath(GREETING_MSG));
    }


}
