package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import org.testng.annotations.Test;
import pages.CategorySelection;
import pages.HomePage;
import pages.LogOnPage;
import pages.ProductPage;

public class ProductTest extends BaseTest{
    HomePage homePage;
    LogOnPage logOnPage;
    CategorySelection categorySelection;
    ProductPage productPage;

    @Test
    @Description("Test Description: Perform login, select a category, apply filters and sorting options and select a specific product from the filtered list.")
    @Severity(SeverityLevel.NORMAL)
    public void selectProductWithFilterAndSorting(){
        homePage = new HomePage(driver);
        logOnPage = new LogOnPage(driver);
        categorySelection = new CategorySelection(driver);
        productPage = new ProductPage(driver);

        goToLoginPage();
        performLogin();
        selectCategory();
        applyFiltersAndSorting();
        selectProduct();

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
    @Step("Apply filters and sorting options")
    public void applyFiltersAndSorting() {
        productPage
                .setFilterOptionBody5_6()
                .setFilterOptionBody6_7()
                .setFilterOptionBody6()
                .setSelectColor()
                .setSelectSortBtn()
                .setBestSellers();
    }
    @Step("Select product number {0} from the list")
    public void selectProduct() {
        productPage.selectProduct();
    }


}
