package tests;

import io.qameta.allure.*;
import org.testng.annotations.Test;
import pages.HomePage;

public class HomeTest extends BaseTest {

    HomePage homePage;

    @Test
    @Description("Test Description: Clicking the 'Sign In' button to navigate to the login page.")
    @Severity(SeverityLevel.CRITICAL)
    @Feature("Authentication")
    @Story("As a user, I want to navigate to the login page by clicking the 'Sign In' button.")
    public void logInTest(){
        homePage = new HomePage(driver);
        homePage.goToLoginPage();
    }
}
