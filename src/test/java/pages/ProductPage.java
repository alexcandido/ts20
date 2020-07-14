package pages;

import manager.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.CommonActions;

public class ProductPage {

    private WebDriver driver;
    private WebDriverWait wait;
    private CommonActions commonActions;

    public By favoriteIcon = By.xpath("//div[contains(@class,'favorite-button')]");
    public By isFavorite = By.cssSelector(".djqnfb");
    private By psnCard = By.xpath("//div[contains(@class, 'main-grid')]//h2[contains(text(),'Gift Card Digital Playstation Store R$ 100')]");
    private By buyBtn = By.cssSelector("#btn-buy[value=Comprar]");
    
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

}
