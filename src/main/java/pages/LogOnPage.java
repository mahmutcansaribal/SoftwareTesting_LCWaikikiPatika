package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LogOnPage extends BasePage {
    String email = "mahmutcansaribal_19@hotmail.com";
    String password = "Mahmutcan60,";

    By emailLocator = By.name("emailAndPhone");
    By continueBtn = By.xpath("//button[normalize-space()='Devam Et']");
    By passwordLocator = By.name("password");
    By loginBtn = By.xpath("//button[contains(text(),'Giriş Yap')]");
    public LogOnPage(WebDriver driver){
        super(driver);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));

    }
    public void setEmail(){
        click(emailLocator);
        sendKeys(emailLocator,email);
    }
    public void setContinueBtn(){
        click(continueBtn);
    }
    public void setPassword(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(passwordLocator));
        sendKeys(passwordLocator,password);
    }
    public void setLoginBtn(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(loginBtn));
        click(loginBtn);
        navigateToHomePage();
    }

    //Capctha istenmiyorsa setLoginBtn içerisinden navigateTo Fonk aktif hale getirilebilir.
//    public void threadFonk(){
//   //Manuel olarak Telefon Captcha geçmek için koyuldu.
//    try{
//        Thread.sleep(25000);
//    }catch (InterruptedException e){
//        e.printStackTrace();
//        }
//    }
}
