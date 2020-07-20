package pages;

import manager.DriverFactory;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.CommonActions;

import java.util.List;

public class ProductPage {

    private WebDriver driver;
    private WebDriverWait wait;
    private CommonActions commonActions;

    public By favoriteIcon = By.xpath("//div[contains(@class,'favorite-button')]");
    public By isFavorite = By.cssSelector(".djqnfb");
    private By psnCard = By.xpath("//div[contains(@class, 'main-grid')]//h2[contains(text(),'Gift Card Digital Playstation Store R$ 100')]");
    private By buyBtn = By.cssSelector("#btn-buy[value=Comprar]");
    private By paymentOptionsLink = By.xpath("//span[contains(text(),'Formas de parcelamento')]");
    private By paymentOptions = By.xpath("//span[contains(@class,'NavTitleUI')]");
    private By zipCodeInput = By.cssSelector(".input-box");
    private By okBtn = By.cssSelector("button[type=submit][value=OK]");
    private By shippingTable = By.cssSelector(".TableUI-v0rmpz-0 .THead-sc-1wy23hs-0");

    
    public ProductPage(WebDriver driver){
        this.driver = driver;
        wait = DriverFactory.getWait();
        commonActions = new CommonActions(driver);
    }
    public void addProductToFavoriteList(){
        commonActions.click(favoriteIcon);
        commonActions.waitForAnElementBeVisible(isFavorite);
    }

    public void clickOnPsnCard() { commonActions.click(psnCard); }

    public void clickToBuy() { commonActions.click(buyBtn); }

    public void openPaymentOptions(){
        ((JavascriptExecutor)driver).executeScript("window.scrollTo(0,"+driver.findElement(paymentOptionsLink).getLocation().y+")");
        commonActions.click(paymentOptionsLink);
    }

    public List<WebElement> getPaymentOptionsList(){
        return commonActions.findElements(paymentOptions);
    }

    public void fillZipCode(String zip) {
        commonActions.setElementValue(zipCodeInput, zip);
        commonActions.click(okBtn);
    }

    public boolean getShippingTable() {
        if (commonActions.findElement(shippingTable).isDisplayed()) {
            return true;
        }
        else return false;
    }

}
