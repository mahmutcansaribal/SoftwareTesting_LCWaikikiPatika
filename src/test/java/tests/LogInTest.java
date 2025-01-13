package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;
import pages.HomePage;

public class LogInTest extends BaseTest {

    HomePage homePage;

    @Test
    @Description("Test Description: Clicking the 'Sign In' button to navigate to the login page.")
    @Severity(SeverityLevel.CRITICAL)
    public void logInTest(){
        homePage = new HomePage(driver);
        homePage.goToLoginPage();
    }
}
