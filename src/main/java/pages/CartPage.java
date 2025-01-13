package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CartPage extends BasePage{
    public CartPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver,this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }
    // By productCartListLocator = By.cssSelector(".rd-cart-item.shoppingcart-item");
    By itemPlusLocator = By.cssSelector(".oq-up.plus");
    @FindBy(xpath = "//span[@class='rd-cart-item-code']")
    WebElement productName;
    @FindBy(xpath = "//strong[normalize-space()='Koyu Bej']")
    WebElement colorName;

    @FindBy(css = ".item-quantity-input")
    WebElement itemCount;

    @FindBy(xpath = "//span[@class='rd-cart-item-price mb-15']")
    WebElement itemPrice;

    @FindBy(xpath = "//div[@class='price-info-area']//span[@class='total-grand-box-amount'][normalize-space()='2.999,98 TL']")
    WebElement totalItemPrice;

    @FindBy(xpath = "//a[@title='Favoriye Ekle']")
    WebElement addFavoriteBtn;
    @FindBy(xpath = "//a[text()='ÖDEME ADIMINA GEÇ']")
    WebElement paymentStep;

    public void itemPlus(){
        wait.until(ExpectedConditions.elementToBeClickable(itemPlusLocator));
        click(itemPlusLocator);
    }

    public String setProductNameCheck(){
        wait.until(ExpectedConditions.visibilityOf(productName));
        String actualProductName = productName.getText();
        return actualProductName;
    }
    public String setColorCheck(){
        wait.until(ExpectedConditions.visibilityOf(colorName));
        String actualColorName = colorName.getText();
        return actualColorName;
    }
    public String setItemCountCheck(){
        wait.until(ExpectedConditions.attributeToBe(itemCount,"value","2"));
        String value = itemCount.getAttribute("value");
        return value;
    }

    public String setPriceCheck(){
        wait.until(driver -> !itemPrice.getText().equals("1.499,99 TL"));
        String actualPrice = itemPrice.getText();
        return actualPrice;
    }
    public String setTotalItemPrice(){
        wait.until(ExpectedConditions.visibilityOf(totalItemPrice));
        String actualTotalPrice = totalItemPrice.getText();
        return actualTotalPrice;
    }

    public void setAddFavorite(){
        threadFonk();
        wait.until(ExpectedConditions.visibilityOf(addFavoriteBtn));
        clickIfNotSelected(addFavoriteBtn);
    }

    public void clickPaymentStep(){
        wait.until(ExpectedConditions.visibilityOf(paymentStep));
        navigateToFavoritePage();
    }

    public void clickIfNotSelected(WebElement element) {
        if (!element.isSelected()) {
            wait.until(ExpectedConditions.elementToBeClickable(element)).click();
        } else {
            System.out.println("Öğe zaten seçili!");
        }
    }

    public void threadFonk(){
        try{
            Thread.sleep(3000);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
