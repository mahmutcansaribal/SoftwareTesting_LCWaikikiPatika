import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage extends BasePage {
    By cookiesAccept = By.id("cookieseal-banner-accept");

    @FindBy(id="user_1_")
    WebElement logInBtn;
    By logOnBtn = By.xpath("//a[@class='cart-action__btn cart-action__btn--bg-blue']");

    public HomePage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver,this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.actions = new Actions(driver);
    }
    public void goToLogin(){
        click(cookiesAccept);
        wait.until(ExpectedConditions.visibilityOf(logInBtn));
        actions.moveToElement(logInBtn).perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(logOnBtn));
        click(logOnBtn);
    }
}
