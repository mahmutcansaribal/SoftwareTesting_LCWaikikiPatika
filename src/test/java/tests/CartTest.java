package tests;

import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

public class CartTest extends BaseTest {

    HomePage homePage;
    LogOnPage logOnPage;
    CategorySelection categorySelection;
    ProductPage productPage;
    ProductDetailsPage productDetailsPage;
    CartPage cartPage;


    @Test
    @Description("Test Description: From login to payment step, add a product to the cart, verify its details, add it to favorites, and proceed to the payment step.")
    @Severity(SeverityLevel.CRITICAL)
    @Feature("Cart and Payment Management")
    @Story("As a user, I want to add a product to my cart, verify its details, add it to favorites, and proceed to the payment step.")
    public void AddProductToCart() {
        homePage = new HomePage(driver);
        logOnPage = new LogOnPage(driver);
        categorySelection = new CategorySelection(driver);
        productPage = new ProductPage(driver);
        productDetailsPage = new ProductDetailsPage(driver);
        cartPage = new CartPage(driver);

        goToLoginPage();

        performLogin();

        selectCategory();

        applyFiltersAndSorting();

        selectProduct();
        selectBodySize();

        addToCart();
        goToCart();

        increaseItemCount();
        addToFavorites();

        verifyProductDetails();
        proceedToPayment();
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
    @Step("Select product from the list")
    public void selectProduct() {
        productPage.selectProduct();
    }
    @Step("Select body size option")
    public void selectBodySize() {
        productDetailsPage.selectBodySize();
    }
    @Step("Add the selected product to the cart")
    public void addToCart() {
        productDetailsPage.addToCart();
    }
    @Step("Navigate to the cart")
    public void goToCart() {
        homePage.goToCart();
    }
    @Step("Increase the item count in the cart")
    public void increaseItemCount() {
        cartPage.itemPlus();
    }
    @Step("Add the product to favorites")
    public void addToFavorites() {
        cartPage.setAddFavorite();
    }
    @Step("Verify product details: name, color, item count, and price")
    public void verifyProductDetails() {
        Assert.assertEquals(cartPage.setProductNameCheck(), "Mont", "Product name is incorrect!");
        Assert.assertEquals(cartPage.setColorCheck(), "Koyu Bej", "Product color is incorrect!");
        Assert.assertEquals(cartPage.setItemCountCheck(), "2", "Product quantity is incorrect!");
        Assert.assertEquals(cartPage.setPriceCheck(), cartPage.setTotalItemPrice(), "Prices do not match!");
    }
    @Step("Proceed to the payment step")
    public void proceedToPayment() {
        cartPage.clickPaymentStep();
        homePage.goToFavorites();
    }
}
