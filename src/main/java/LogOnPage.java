import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LogOnPage extends BasePage{
    By emailLocator = By.name("emailAndPhone");
    By continueBtn = By.xpath("//button[normalize-space()='Devam Et']");
    By passwordLocator = By.name("password");
    By loginBtn = By.xpath("//button[contains(text(),'Giriş Yap')]");
    public LogOnPage(WebDriver driver){
        super(driver);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    }
    public void setEmail(String email){
        click(emailLocator);
        sendKeys(emailLocator,email);
    }
    public void setContinueBtn(){
        click(continueBtn);
    }
    public void setPassword(String password){
        wait.until(ExpectedConditions.visibilityOfElementLocated(passwordLocator));
        sendKeys(passwordLocator,password);
    }
    public void setLoginBtn(){
        navigateToUrl();
//        wait.until(ExpectedConditions.visibilityOfElementLocated(loginBtn));
//        click(loginBtn);
    }
}
