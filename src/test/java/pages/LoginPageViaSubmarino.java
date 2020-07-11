package pages;

import manager.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.CommonActions;

public class LoginPageViaSubmarino {

    private WebDriver driver;
    private WebDriverWait wait;
    private CommonActions commonActions;

    private By subEmailInput = By.cssSelector("#email-input");
    private By subPasswordInput = By.cssSelector("#password-input");
    private By subLoginBtn = By.cssSelector("#login-button");

    public LoginPageViaSubmarino (WebDriver driver){
        this.driver = driver;
        wait = DriverFactory.getWait();
        commonActions = new CommonActions(driver);
    }

    public void fillEmail(String email){
        commonActions.setElementValue(subEmailInput, email);
    }

    public void fillPassword(String password){
        commonActions.setElementValue(subPasswordInput, password);
    }

    public void clickLoginDefault(){
        commonActions.click(subLoginBtn);
    }

}
