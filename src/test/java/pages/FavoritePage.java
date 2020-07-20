package pages;

import manager.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.CommonActions;

public class FavoritePage {

    private WebDriver driver;
    private WebDriverWait wait;
    private CommonActions commonActions;

    private By emptyWishListMessage = By.xpath("//div[@id='content']//span");
    private By favoriteIcon = By.xpath("//div[contains(@class,'TouchableFavorite')]");
    private By productCard = By.xpath("//div[contains(@class,'product-card-photo')]");
    private By productName = By.xpath("//h2[contains(@class,'TitleUI')]");


    public FavoritePage(WebDriver driver) {
        this.driver = driver;
        wait = DriverFactory.getWait();
        commonActions = new CommonActions(driver);
    }

    public void clearWishList() {
        commonActions.waitForAnElementBeVisible(favoriteIcon);

        while (!commonActions.findElement(emptyWishListMessage).getText().equals("Você não possui produtos salvos")) {
            commonActions.findElement(favoriteIcon).click();
        }
    }

    public String getProductName() {
        commonActions.waitForAnElementBeVisible(productCard);
        return commonActions.findElement(productName).getText();
    }

    public String getEmptyWishListMessage() {
        return commonActions.findElement(emptyWishListMessage).getText();
    }
}
