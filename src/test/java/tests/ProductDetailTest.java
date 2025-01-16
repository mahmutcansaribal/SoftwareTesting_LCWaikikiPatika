package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import org.testng.annotations.Test;
import pages.*;

public class ProductDetailTest extends BaseTest{

    HomePage homePage;
    LogOnPage logOnPage;
    CategorySelection categorySelection;
    ProductPage productPage;
    ProductDetailsPage productDetailsPage;


    @Test
    @Description("Test Description: Select a body size for the product and add it to the cart.")
    @Severity(SeverityLevel.CRITICAL)
    public void AddProductToCart(){
        homePage = new HomePage(driver);
        logOnPage = new LogOnPage(driver);
        categorySelection = new CategorySelection(driver);
        productPage = new ProductPage(driver);
        productDetailsPage = new ProductDetailsPage(driver);

        goToLoginPage();
        performLogin();
        selectCategory();
        applyFiltersAndSorting();
        selectProduct(3);
        selectBodySize(1);
        addToCart();

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
    public void selectProduct(int productIndex) {
        productPage.selectProduct(productIndex);
    }

    @Step("Select body size option {0}")
    public void selectBodySize(int bodySizeIndex) {
        productDetailsPage.selectBodySize(bodySizeIndex);
    }

    @Step("Add the selected product to the cart")
    public void addToCart() {
        productDetailsPage.addToCart();
    }
}
