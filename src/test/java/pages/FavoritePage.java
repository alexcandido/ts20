package pages;

import manager.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FavoritePage {

    private WebDriver driver;
    private WebDriverWait wait;

    private By emptyWishList = By.xpath("//div[@id='content']//span[contains(text(),'Você não possui produtos salvos')]");
    private By favoriteIcon = By.xpath("//div[contains(@class,'TouchableFavorite')]");

    public FavoritePage(WebDriver driver){
        this.driver = driver;
        wait = DriverFactory.getWait();
    }

    public void clearWishList(){
        while (driver.findElement(favoriteIcon).isDisplayed()){
            driver.findElement(favoriteIcon).click();
        }
    }
}
