package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class BasePage {
    private String baseFavoriteUrl = "https://www.lcw.com/favorilerim";
    private String baseUrl = "https://www.lcw.com/";
    protected String email = "mahmutcansaribal_19@hotmail.com";
    protected String password = "test123a";

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Actions actions;

    public BasePage(WebDriver driver){
        this.driver = driver;
    }
    public List<WebElement> findAllProducts(By locator){
        return driver.findElements(locator);
    }
    public WebElement find(By locator){
        return driver.findElement(locator);
    }
    public void click(By locator){
        find(locator).click();
    }
    public void sendKeys(By locator, String text){
        find(locator).sendKeys(text);
    }
    public void navigateToHomePage(){
        driver.get(baseUrl);
    }
    public void navigateToFavoritePage(){
        driver.get(baseFavoriteUrl);
    }
    public void waitToLoadingAnimation(){
        wait.until(ExpectedConditions.not(
                ExpectedConditions.attributeContains(
                        By.cssSelector(".desktop-filter-area"),
                        "class",
                        "desktop-filter-area--fetching")
        ));
    }
    public void scrollToElement(WebElement element){
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

}
