package pages;

import manager.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.CommonActions;
import util.Constants;

public class SubmarinoMainPage {

    private WebDriver driver;
    private WebDriverWait wait;
    private CommonActions commonActions;

    private By signBtn = By.cssSelector("#h_usr-link");
    private By logInDefaultBtn = By.cssSelector("#h_usr-signin");
    private By logInFaceBtn = By.cssSelector("#h_usr-signinFace");
    public By userName = By.cssSelector(".usr-act-text");

    private By searchBarInput = By.cssSelector("#h_search-input");

    private By favoriteBtn = By.cssSelector("#h_wishlist .wish-link");
    private By registerBtn = By.cssSelector(".usr-actions .usr-signup");
    private By emailOffers = By.cssSelector("input[placeholder='Digite seu E-mail'][name=email]");
    private By cadastrarBtn = By.cssSelector("button[type=submit][value=Cadastrar]");
    private By youtubeIcn = By.cssSelector(".sc-list [title=Youtube]");
    private By facebookIcn = By.cssSelector(".sc-list [title=Facebook]");
    private By instaIcn = By.cssSelector(".sc-list [title=Instagram]");
    private By twitterIcn = By.cssSelector(".sc-list [title=Twitter]");

    public static final By SUCCESS_MESSAGE = By.xpath("//span[contains(text(),'Seu e-mail foi cadastrado com sucesso!')]");


    public SubmarinoMainPage(WebDriver driver){
        this.driver = driver;
        commonActions = new CommonActions(driver);
        wait = DriverFactory.getWait();
    }
/*
    public void setElement(By elementId, String text) {
        WebElement element = driver.findElement(elementId);
        element.clear();
        element.sendKeys(text);
    }
*/

    public SubmarinoMainPage accessPage(){
        driver.get(Constants.SUBMARINO_MAIN_URL);
        return this;
    }

    public void openFavoriteWishList(){
        commonActions.click(favoriteBtn);
    }

    public void openNewUserForm() {
        commonActions.click(registerBtn);
    }

    public void clickSubmitBtn() {
        commonActions.click(cadastrarBtn);
    }

    public void setEmailField(String email) {
        commonActions.setElementValue(emailOffers, email);
    }

    public void clickLogin(){
        commonActions.click(signBtn);
    }

    public void clickLoginDefault(){
        commonActions.click(logInDefaultBtn);
    }

    public void clickLoginFb(){
        commonActions.click(logInFaceBtn);
    }

    public void fillSearchBarAndPressEnter(String product){
        commonActions.click(searchBarInput);
        commonActions.setElementValue(searchBarInput, product);
        commonActions.sendKeys(searchBarInput, Keys.ENTER);
    }

}
