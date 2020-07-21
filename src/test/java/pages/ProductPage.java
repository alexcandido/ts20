package pages;

import manager.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.CommonActions;

import java.util.List;

public class ProductPage {

    private WebDriver driver;
    private WebDriverWait wait;
    private CommonActions commonActions;

    private By favoriteIcon = By.xpath("//div[contains(@class,'favorite-button')]");
    private By isFavorite = By.cssSelector(".djqnfb");

    private By buyBtn = By.cssSelector("#btn-buy[value=Comprar]");
    private By paymentOptionsLink = By.xpath("//span[@role='link' and text()='Formas de parcelamento']");
    private By paymentOptions = By.xpath("//span[contains(@class,'NavTitleUI')]");
    private By zipCodeInput = By.cssSelector(".input-box");
    private By okBtn = By.cssSelector("button[type=submit][value=OK]");
    private By shippingTable = By.cssSelector(".TableUI-v0rmpz-0 .THead-sc-1wy23hs-0");

    private String productSelectorByNameStr = "//div[contains(@class, 'main-grid')]//h2[contains(text(),'%s')]";


    public ProductPage(WebDriver driver) {
        this.driver = driver;
        wait = DriverFactory.getWait();
        commonActions = new CommonActions(driver);
    }

    public void addProductToFavoriteList() {
        commonActions.click(favoriteIcon);
        commonActions.waitForAnElementBeVisible(isFavorite);
    }

    public void clickOnProductByName(String productName) {
        commonActions.click(commonActions.getXpathSelectorModifiedByRegex(productSelectorByNameStr, productName));
    }

    public void clickToBuy() {
        commonActions.click(buyBtn);
    }

    public void openPaymentOptions() {
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0," + driver.findElement(paymentOptionsLink).getLocation().y + ")");
        commonActions.click(paymentOptionsLink);
    }

    public List<WebElement> getPaymentOptionsList() {
        return commonActions.findElements(paymentOptions);
    }

    public void fillZipCode(String zip) {
        commonActions.scrollToElement(zipCodeInput);
        commonActions.setElementValue(zipCodeInput, zip);
        commonActions.click(okBtn);
    }

    public boolean isShippingTableDisplayed() {
        commonActions.scrollToElement(shippingTable);
        if (commonActions.findElement(shippingTable).isDisplayed()) {
            return true;
        } else {
            return false;
        }
    }

}
