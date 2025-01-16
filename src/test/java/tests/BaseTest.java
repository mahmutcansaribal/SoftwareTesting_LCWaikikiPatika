package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import utilities.ExtentReportManager;

@Listeners(ExtentReportManager.class)
public class BaseTest {

    public WebDriver driver;
    public String baseUrl = "https://www.lcw.com/";

    @BeforeMethod
    public void setUp(){
        ChromeOptions options = new ChromeOptions();
       // options.addArguments("--disable-blink-features=AutomationControlled");

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get(baseUrl);
    }

    @AfterSuite
    public void tearDown(){
        driver.quit();
    }
}
