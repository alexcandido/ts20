package pages;

import manager.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.CommonActions;

public class SearchPage {

    private WebDriver driver;
    private WebDriverWait wait;
    private CommonActions commonActions;

    private By relatedSearchTerm = By.cssSelector(".card-suggestions-link");
    private By relatedSearchTitle = By.cssSelector(".h1.page-title");
    private By relatedSearchProductsOnGrid = By.cssSelector(".main-grid > .product-grid-item");
    private By foundProduct = By.cssSelector(".product-grid-item");

    public SearchPage(WebDriver driver) {
        this.driver = driver;
        wait = DriverFactory.getWait();
        commonActions = new CommonActions(driver);
    }

    public String getRelatedSearchTerm() {
        return commonActions.findElement(relatedSearchTerm).getText();
    }

    public String getRelatedSearchTitle() {
        return commonActions.findElement(relatedSearchTitle).getText();
    }

    public int getItemsNumberOnGrid() {
        return commonActions.findElements(relatedSearchProductsOnGrid).size();
    }

    public void clickOnFoundItem() {
        commonActions.click(foundProduct);
    }
}
