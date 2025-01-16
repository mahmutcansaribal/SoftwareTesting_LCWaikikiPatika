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
    //    @FindBy(xpath = "//a[@class='cart-action__btn cart-action__btn--bg-blue']")
    //    WebElement logOnBtn;
    By logOnBtn = By.xpath("//a[@class='cart-action__btn cart-action__btn--bg-blue']");
    By cartContanierLocator = By.xpath("//span[normalize-space()='Sepetim']");
    By favoritesBtnLocator = By.xpath("//span[normalize-space()='Favorilerim']");
    //Ürün sayısının artıp artmadığını kontrol etmek için sepeti buluyoruz.
    By cartItemCount = By.cssSelector(".badge-circle");
    public HomePage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver,this);
        this.wait = new WebDriverWait(driver,Duration.ofSeconds(15));
        this.actions = new Actions(driver);
    }

    //Giriş yap
    public void goToLoginPage(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(cookiesAccept));
        click(cookiesAccept);

        wait.until(ExpectedConditions.visibilityOf(logInBtn));
        actions.moveToElement(logInBtn).perform();

        wait.until(ExpectedConditions.visibilityOfElementLocated(logOnBtn));
        click(logOnBtn);
    }

    // Sepete Git
    public void goToCart(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(cartItemCount));
        String count = find(cartItemCount).getText();
        int itemCount = Integer.parseInt(count);
        if(itemCount>0){
            click(cartContanierLocator);
        }else{
            System.out.println("Ürün bulunamadı!");
        }
    }
    public void goToFavorites(){
        wait.until(ExpectedConditions.elementToBeClickable(favoritesBtnLocator));
        click(favoritesBtnLocator);
    }
}
