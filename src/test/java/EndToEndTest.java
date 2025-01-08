import org.testng.annotations.Test;

public class EndToEndTest extends BaseTest{

    private TestConfig config;
    HomePage homePage;
    LogOnPage logOnPage;
    CategorySelection categorySelection;



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
    public void navigateToCategorySelection(){
        categorySelection = new CategorySelection(driver);

        categorySelection.moveToHeaderItem();
        categorySelection.hoverOverTabHeaderItem();
        categorySelection.clickOnCategoryZoneItem();
    }
}
