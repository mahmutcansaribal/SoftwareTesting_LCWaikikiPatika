package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LogOnPage extends BasePage {

    By emailLocator = By.name("emailAndPhone");
    By continueBtn = By.xpath("//button[normalize-space()='Devam Et']");
    By passwordLocator = By.name("password");
    By loginBtn = By.xpath("//button[contains(text(),'Giriş Yap')]");
    public LogOnPage(WebDriver driver){
        super(driver);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }
    public LogOnPage setEmail(){
        wait.until(ExpectedConditions.elementToBeClickable(emailLocator));
        click(emailLocator);
        sendKeys(emailLocator,email);
        return this;
    }
    public LogOnPage setContinueBtn(){
        wait.until(ExpectedConditions.elementToBeClickable(continueBtn));
        click(continueBtn);
        return this;
    }
    public LogOnPage setPassword(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(passwordLocator));
        sendKeys(passwordLocator,password);
        return this;
    }
    public LogOnPage setLoginBtn(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(loginBtn));
        wait.until(ExpectedConditions.elementToBeClickable(loginBtn));
        click(loginBtn);
        navigateToHomePage();
        return this;
    }

}
