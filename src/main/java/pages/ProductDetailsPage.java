package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ProductDetailsPage extends BasePage {

    public ProductDetailsPage(WebDriver driver){
        super(driver);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    By bodySizeLocator = By.cssSelector(".option-box.option-size-box.option-size-box__stripped");
    By addToCartLocator = By.cssSelector(".add-to-card");

    public ProductDetailsPage selectBodySize(int i){
        WebElement bodySizeElement = wait.until(ExpectedConditions.elementToBeClickable(bodySizes().get(i)));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".exploreBodyContainer-bg.showTool")));
        bodySizeElement.click();
        return this;
    }
    public ProductDetailsPage addToCart(){
        WebElement addToCartButton = wait.until(ExpectedConditions.elementToBeClickable(addToCartLocator));
        addToCartButton.click();
        return this;
    }

    private List<WebElement> bodySizes(){
        List<WebElement> bodysizes = findAllProducts(bodySizeLocator);
        System.out.println("Toplam Body sayısı : "+bodysizes.size());
        return bodysizes;
    }
}
