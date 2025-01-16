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

    By selectSortBtn2 = By.xpath("//button[@class='dropdown-button__button']");
    By bestSellers = By.xpath("//a[normalize-space()='En çok satanlar']");
    By currentPriceLocator = By.xpath("//div[@class='product-image']");

    public ProductPage(WebDriver driver){
        super(driver);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        this.actions = new Actions(driver);
        PageFactory.initElements(driver, this);
    }


    public void setFilterOptionBody5_6(){
        waitToLoadingAnimation();
        actions.moveToElement(filterOptionBody5_6).perform();
        wait.until(ExpectedConditions.elementToBeClickable(filterOptionBody5_6)).click();

    }

    public void setFilterOptionBody6(){
        //BasePage'den gelen fonksiyonumuz.
        waitToLoadingAnimation();

        actions.moveToElement(filterOptionBody6).perform();
        wait.until(ExpectedConditions.elementToBeClickable(filterOptionBody6)).click();
    }
    public void setFilterOptionBody6_7(){
        waitToLoadingAnimation();

        actions.moveToElement(filterOptionBody6_7).perform();
        wait.until(ExpectedConditions.elementToBeClickable(filterOptionBody6_7)).click();
    }

    public void setSelectColor(){
        waitToLoadingAnimation();

        actions.moveToElement(selectColor).perform();
        wait.until(ExpectedConditions.elementToBeClickable(selectColor)).click();
    }
    public void setSelectSortBtn(){
        waitToLoadingAnimation();
        scrollToElement(selectSortBtn);
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, -200);");
        actions.moveToElement(selectSortBtn).click().perform();
    }
    public void setBestSellers(){
        waitToLoadingAnimation();
        wait.until(ExpectedConditions.elementToBeClickable(bestSellers)).click();
    }
    public void selectProduct(int i){
        waitToLoadingAnimation();

        List<WebElement> products = getAllProducts();
        if (i >= 0 && i < products.size()) {
            products.get(i).click();
        } else {
            System.out.println("Geçersiz ürün indeksi: " + i);
        }
    }
    //Ürünleri listeleyebilmek için kullanılan fonksiyon.
    private List<WebElement> getAllProducts(){
        List<WebElement> products = findAllProducts(currentPriceLocator);
        System.out.println("Toplam Ürün sayısı : "+products.size());
        return products;
    }


}


