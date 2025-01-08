import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class BasePage {
    public String baseUrl = "https://www.lcw.com/";
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Actions actions;

    public BasePage(WebDriver driver){
        this.driver = driver;
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
    public List<WebElement> findAllProducts(By locator){
        return driver.findElements(locator);
    }

}
