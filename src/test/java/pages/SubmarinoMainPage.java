package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import util.Constants;

public class SubmarinoMainPage {

    private WebDriver driver;

    private By favoriteBtn = By.cssSelector("#h_wishlist .wish-link");
    private By registerBtn = By.cssSelector(".usr-actions .usr-signup");

    public SubmarinoMainPage(WebDriver driver){
        this.driver = driver;
    }

    public SubmarinoMainPage accessPage(){
        driver.get(Constants.SUBMARINO_MAIN_URL);
        return this;
    }

    public void openFavoriteWishList(){
        driver.findElement(favoriteBtn).click();
    }

    public void openNewUserForm() {
        driver.findElement(registerBtn).click();
    }
}
