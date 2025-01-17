package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class ProductDetailsPage extends BasePage {

    public ProductDetailsPage(WebDriver driver){
        super(driver);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        PageFactory.initElements(driver,this);
    }

    By addToCartLocator = By.cssSelector(".add-to-card");
    @FindBy(xpath = "//button[contains(text(),'5-6 Yaş')]")
    WebElement bodySize;

    public ProductDetailsPage selectBodySize(){
        wait.until(ExpectedConditions.visibilityOf(bodySize));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".exploreBodyContainer-bg.showTool")));
        bodySize.click();
        return this;
    }
    public ProductDetailsPage addToCart(){
        WebElement addToCartButton = wait.until(ExpectedConditions.elementToBeClickable(addToCartLocator));
        addToCartButton.click();
        return this;
    }

}
