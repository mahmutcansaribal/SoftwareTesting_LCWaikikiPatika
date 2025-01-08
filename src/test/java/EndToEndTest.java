import org.testng.annotations.Test;

public class EndToEndTest extends BaseTest{

    private TestConfig config;
    HomePage homePage;
    LogOnPage logOnPage;
    CategorySelection categorySelection;
    ProductPage productPage;



    @Test(priority = 1)
    public void logInTest(){
        homePage = new HomePage(driver);

        homePage.goToLogin();
    }
    @Test(priority = 2, dependsOnMethods = {"logInTest"})
    public void logOnTest() {
        logOnPage = new LogOnPage(driver);
        config = new TestConfig();

        logOnPage.setEmail(config.getEmail());
        logOnPage.setContinueBtn();
        logOnPage.setPassword(config.getPassword());
        logOnPage.setLoginBtn();
    }
    @Test(priority = 3,dependsOnMethods = {"logOnTest"})
    public void navigateToCategorySelectionTest(){
        categorySelection = new CategorySelection(driver);

        categorySelection.moveToHeaderItem();
        categorySelection.hoverOverTabHeaderItem();
        categorySelection.clickOnCategoryZoneItem();
    }

    @Test(priority = 4, dependsOnMethods = {"navigateToCategorySelectionTest"})
    public void productFilterTest(){
        productPage = new ProductPage(driver);
        //Body Filter
        productPage.setFilterOptionBody5_6();
        productPage.setFilterOptionBody6_7();
        productPage.setFilterOptionBody6();
        //Color Filter
        productPage.setSelectColor();
        //Sort DropDown
        productPage.setSelectSortBtn();
    }
}
