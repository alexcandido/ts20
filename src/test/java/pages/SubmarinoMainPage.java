package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import util.Constants;

public class SubmarinoMainPage {

    private WebDriver driver;

    private By favoriteBtn = By.cssSelector("#h_wishlist .wish-link");
    private By registerBtn = By.cssSelector(".usr-actions .usr-signup");
    private By emailOffers = By.cssSelector("input[placeholder='Digite seu E-mail'][name=email]");
    private By cadastrarBtn = By.cssSelector("button[type=submit][value=Cadastrar]");
    private By successMsg = By.xpath("//span[contains(text(),'Seu e-mail foi cadastrado com sucesso!')]");


    public SubmarinoMainPage(WebDriver driver){
        this.driver = driver;
    }

    public void setElement(By elementId, String text) {
        WebElement element = driver.findElement(elementId);
        element.clear();
        element.sendKeys(text);
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

    public void clickSubmitBtn() {
        driver.findElement(cadastrarBtn).click();
    }

    public void setEmailField(String email) {
        setElement(emailOffers, email);
    }

    public String getSuccessMessage() {
        WebElement element = driver.findElement(successMsg);
        return element.getText().trim();
    }
}
