

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class ProductPage extends BasePage{



    @FindBy(xpath = "//div[contains(@class, 'collapsible-filter-container__content-area--size-filter')]//span[@class='filter-option__text' and text()='5-6 Yaş']")
    WebElement filterOptionBody5_6;
    @FindBy(xpath = "//div[contains(@class, 'collapsible-filter-container__content-area--size-filter')]//span[@class='filter-option__text' and text()='6 Yaş']")
    WebElement filterOptionBody6;
    @FindBy(xpath = "//div[contains(@class, 'collapsible-filter-container__content-area--size-filter')]//span[@class='filter-option__text' and text()='6-7 Yaş']")
    WebElement filterOptionBody6_7;
    @FindBy(xpath = "//span[@class='color-filter-option__text'][normalize-space()='BEJ']")
    WebElement selectColor;
    @FindBy(xpath = "//button[@class='dropdown-button__button']")
    WebElement selectSortBtn;

    By selectSortBtn2 = By.xpath("//button[@class='dropdown-button__button']");
    By bestSellers = By.xpath("//a[normalize-space()='En çok satanlar']");
    public ProductPage(WebDriver driver){
        super(driver);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10),Duration.ofSeconds(2));
        this.actions = new Actions(driver);
        PageFactory.initElements(driver, this);
    }

    public void threadFonk(){
        try{
            Thread.sleep(2100);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void setFilterOptionBody5_6(){
        actions.moveToElement(filterOptionBody5_6).perform();
        wait.until(ExpectedConditions.elementToBeClickable(filterOptionBody5_6)).click();
        threadFonk();

    }

    public void setFilterOptionBody6(){
        actions.moveToElement(filterOptionBody6).perform();
        wait.until(ExpectedConditions.elementToBeClickable(filterOptionBody6)).click();
        threadFonk();
    }
    public void setFilterOptionBody6_7(){
        actions.moveToElement(filterOptionBody6_7).perform();
        wait.until(ExpectedConditions.elementToBeClickable(filterOptionBody6_7)).click();
        threadFonk();
    }
    public void setSelectColor(){
        //((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", selectColor);
        actions.moveToElement(selectColor).perform();
        wait.until(ExpectedConditions.elementToBeClickable(selectColor)).click();
        threadFonk();
    }
    public void setSelectSortBtn(){
        threadFonk();
        // ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", selectSortBtn2);
        wait.until(ExpectedConditions.elementToBeClickable(selectSortBtn2)).click();
    }
    public void setBestSellers(){
        wait.until(ExpectedConditions.elementToBeClickable(bestSellers)).click();
    }

}


