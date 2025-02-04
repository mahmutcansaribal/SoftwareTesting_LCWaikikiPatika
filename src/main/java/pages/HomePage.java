package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage extends BasePage {
    By cookiesAccept = By.id("cookieseal-banner-accept");
    @FindBy(id="user_1_")
    WebElement logInBtn;
    By logOnBtn = By.xpath("//a[@class='cart-action__btn cart-action__btn--bg-blue']");
    By cartContanierLocator = By.xpath("//span[normalize-space()='Sepetim']");
    By favoritesBtnLocator = By.xpath("//span[normalize-space()='Favorilerim']");
    By cartItemCount = By.cssSelector(".badge-circle");
    public HomePage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver,this);
        this.wait = new WebDriverWait(driver,Duration.ofSeconds(15));
        this.actions = new Actions(driver);
    }

    //Giriş yap
    public HomePage goToLoginPage(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(cookiesAccept));
        click(cookiesAccept);

        wait.until(ExpectedConditions.visibilityOf(logInBtn));
        actions.moveToElement(logInBtn).perform();

        wait.until(ExpectedConditions.visibilityOfElementLocated(logOnBtn));
        click(logOnBtn);

        return this;
    }

    // Sepete Git
    public HomePage goToCart(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(cartItemCount));
        String count = find(cartItemCount).getText();
        int itemCount = Integer.parseInt(count);
        if(itemCount>0){
            click(cartContanierLocator);
        }else{
            System.out.println("Ürün bulunamadı!");
        }
        return this;
    }
    public HomePage goToFavorites(){
        wait.until(ExpectedConditions.elementToBeClickable(favoritesBtnLocator));
        click(favoritesBtnLocator);
        return this;
    }
}
