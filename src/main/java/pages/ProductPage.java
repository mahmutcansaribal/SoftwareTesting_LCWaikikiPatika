package pages;

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
import java.util.List;


public class ProductPage extends BasePage {

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

    @FindBy(xpath = "//a[@title='Kapüşonlu Kız Çocuk Mont']//img[@class='product-image__image']") // //a[@title='Kapüşonlu Kız Çocuk Mont']//img[@class='product-image__image']
    WebElement selectProduct;
    By bestSellers = By.xpath("//a[normalize-space()='En çok satanlar']");

    public ProductPage(WebDriver driver){
        super(driver);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        this.actions = new Actions(driver);
        PageFactory.initElements(driver, this);
    }


    public ProductPage setFilterOptionBody5_6(){
        waitToLoadingAnimation();
        actions.moveToElement(filterOptionBody5_6).perform();
        wait.until(ExpectedConditions.elementToBeClickable(filterOptionBody5_6)).click();
        return this;
    }

    public ProductPage setFilterOptionBody6(){
        //BasePage'den gelen fonksiyonumuz.
        waitToLoadingAnimation();

        actions.moveToElement(filterOptionBody6).perform();
        wait.until(ExpectedConditions.elementToBeClickable(filterOptionBody6)).click();
        return this;
    }
    public ProductPage setFilterOptionBody6_7(){
        waitToLoadingAnimation();

        actions.moveToElement(filterOptionBody6_7).perform();
        wait.until(ExpectedConditions.elementToBeClickable(filterOptionBody6_7)).click();
        return this;
    }

    public ProductPage setSelectColor(){
        waitToLoadingAnimation();

        actions.moveToElement(selectColor).perform();
        wait.until(ExpectedConditions.elementToBeClickable(selectColor)).click();
        return this;
    }
    public ProductPage setSelectSortBtn(){
        waitToLoadingAnimation();
        scrollToElement(selectSortBtn);
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, -200);");
        actions.moveToElement(selectSortBtn).click().perform();
        return this;
    }
    public ProductPage setBestSellers(){
        waitToLoadingAnimation();
        wait.until(ExpectedConditions.elementToBeClickable(bestSellers)).click();
        return this;
    }
    public ProductPage selectProduct(){
        waitToLoadingAnimation();
        wait.until(ExpectedConditions.visibilityOf(selectProduct));
        wait.until(ExpectedConditions.elementToBeClickable(selectProduct)).click();
        return this;
    }
}


