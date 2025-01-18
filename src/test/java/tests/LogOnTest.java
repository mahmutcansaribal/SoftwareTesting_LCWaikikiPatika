package tests;

import io.qameta.allure.*;

import org.testng.annotations.Test;
import pages.HomePage;
import pages.LogOnPage;

public class LogOnTest extends BaseTest {
    LogOnPage logOnPage;
    HomePage homePage;

    @Test
    @Description("Test Description: Logging in with valid credentials.")
    @Severity(SeverityLevel.CRITICAL)
    @Feature("Authentication")
    @Story("As a user, I want to log in with valid credentials to access my account.")
    public void logOnTest(){
        logOnPage = new LogOnPage(driver);
        homePage = new HomePage(driver);

        goToLoginPage();
        performLogin();
    }

    @Step("Go to login Page")
    public void goToLoginPage(){
        homePage.goToLoginPage();
    }
    @Step("Enter email and click on 'Continue' button")
    public void setEmailAndContinue() {
        logOnPage
            .setEmail()
            .setContinueBtn();
    }
    @Step("Enter password and click on 'Login' button")
    public void performLogin() {
        setEmailAndContinue();
        logOnPage
                .setPassword()
                .setLoginBtn();
    }
}
