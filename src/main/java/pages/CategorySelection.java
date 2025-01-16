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

public class CategorySelection extends BasePage {
    @FindBy(xpath = "//a[normalize-space()='ÇOCUK & BEBEK']")
    WebElement headerItem;

    @FindBy(xpath = "//span[normalize-space()='KIZ ÇOCUK']")
    WebElement tabHeaderItem;
    By selectCategoryZoneItem = By.xpath("//section[contains(@class,'content-tab')]//a[contains(@class,'')][normalize-space()='Mont ve Kaban']");

    public CategorySelection(WebDriver driver){
        super(driver);
        this.actions = new Actions(driver);
        PageFactory.initElements(driver,this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(60));
    }

    public CategorySelection moveToHeaderItem() {
        if (actions != null) {
            wait.until(ExpectedConditions.visibilityOf(headerItem));
            if (headerItem.isDisplayed()) {
                actions.moveToElement(headerItem).perform();
            } else {
                System.out.println("Öğe görünür değil!");
            }
        } else {
            System.out.println("Actions nesnesi null!");
        }
        return this;
    }
    public CategorySelection hoverOverTabHeaderItem(){
        wait.until(ExpectedConditions.visibilityOf(tabHeaderItem));
        actions.moveToElement(tabHeaderItem).perform();
        return this;
    }

    public CategorySelection clickOnCategoryZoneItem(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(selectCategoryZoneItem));
        click(selectCategoryZoneItem);
        return this;
    }

}
