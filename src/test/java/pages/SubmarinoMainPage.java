package pages;

import manager.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
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
    private By userName = By.cssSelector(".usr-act-text");

    private By searchBarInput = By.cssSelector("#h_search-input");

    private By favoriteBtn = By.cssSelector("#h_wishlist .wish-link");
    private By registerBtn = By.cssSelector(".usr-actions .usr-signup");
    private By emailOffers = By.cssSelector("input[placeholder='Digite seu E-mail'][name=email]");
    private By cadastrarBtn = By.cssSelector("button[type=submit][value=Cadastrar]");
    private By cartBtn = By.cssSelector(".crt-link .crt-icon");
    private By emptyCartMsg = By.xpath("//span[contains(text(),'Seu carrinho está vazio')]");
    private By shoppingCartLink = By.cssSelector(".crt-bottom .crt-basquet");

    public static final By YOUTUBE_ICN = By.cssSelector(".sc-list [title=Youtube]");
    public static final By FACEBOOK_ICN = By.cssSelector(".sc-list [title=Facebook]");
    public static final By INSTAGRAM_ICN = By.cssSelector(".sc-list [title=Instagram]");
    public static final By TWITTER_ICN = By.cssSelector(".sc-list [title=Twitter]");
    public static final By SUCCESS_MESSAGE = By.xpath("//span[contains(text(),'Seu e-mail foi cadastrado com sucesso!')]");


    public SubmarinoMainPage(WebDriver driver){
        this.driver = driver;
        commonActions = new CommonActions(driver);
        wait = DriverFactory.getWait();
    }

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

    public void clickShoppingCart(){
        commonActions.click(cartBtn);
    }

    public void goToShoppingCart() {
        clickShoppingCart();
        commonActions.click(shoppingCartLink);
    }

    public void clickLoginFb(){
        commonActions.click(logInFaceBtn);
    }

    public void fillSearchBarAndPressEnter(String product){
        commonActions.click(searchBarInput);
        commonActions.setElementValue(searchBarInput, product);
        commonActions.sendKeys(searchBarInput, Keys.ENTER);
    }

    public By getUserNameSelector(){
        return this.userName;
    }

}
