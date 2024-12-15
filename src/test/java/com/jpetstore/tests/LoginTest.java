package com.jpetstore.tests;
import com.jpetstore.steps.JPetStoreSteps;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import io.qameta.allure.Description;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;


@DisplayName("Login tests")
public class LoginTest extends JPetStoreSteps {

    @Test
    @DisplayName("As a valid user, a user must be able to log in with a valid credentials")
    @Description("Logging into the app via sign on page")
    void doLogin() {
        navigateToApp();
        navigateToSignOnPage();
        doLogin("shibel", "test123");
        assertEquals("Welcome shibel!", getGreetingMessage());

        //Soft Assertion
//        assertAll(
//                () -> assertEquals("Welcome ABC!", getGreetingMessage()),
//                () -> assertEquals("Welcome ABC!", getGreetingMessage())
//        );
    }

    @Nested
    class NegativeTestsLogin{
        @DisplayName("User must not be able to login with invalid credentials")
        @Test
        void invalidLogin(){

            navigateToApp();
            navigateToSignOnPage();
            doLogin("j2ee","j233434");

            assertEquals("Invalid username or password. Signon failed.",
                    getMessageOnInvalidLogin());
        }
    }
}
