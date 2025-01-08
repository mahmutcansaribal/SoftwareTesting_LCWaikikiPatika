import org.testng.annotations.Test;

public class EndToEndTest extends BaseTest{

    HomePage homePage;






    @Test(priority = 1)
    public void logInTest(){
        homePage = new HomePage(driver);

        homePage.goToLogin();
    }
}
