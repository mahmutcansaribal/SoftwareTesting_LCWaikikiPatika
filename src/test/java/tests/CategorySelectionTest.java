package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import org.testng.annotations.Test;
import pages.CategorySelection;
import pages.HomePage;
import pages.LogOnPage;

public class CategorySelectionTest extends BaseTest {

    HomePage homePage;
    LogOnPage logOnPage;
    CategorySelection categorySelection;

    @Test
    @Description("After logging in, select a category")
    @Severity(SeverityLevel.CRITICAL)
    public void categorySelectionTest() {
        homePage = new HomePage(driver);
        logOnPage = new LogOnPage(driver);
        categorySelection = new CategorySelection(driver);

        goToLoginPage();
        performLogin();
        selectCategory();
    }

    @Step("Go to the login page")
    public void goToLoginPage() {
        homePage.goToLoginPage();
    }

    @Step("Log in with username and password")
    public void performLogin() {
        logOnPage
                .setEmail()
                .setContinueBtn()
                .setPassword()
                .setLoginBtn();
    }

    @Step("Select a category")
    public void selectCategory() {
        categorySelection
                .moveToHeaderItem()
                .hoverOverTabHeaderItem()
                .clickOnCategoryZoneItem();
    }
}
