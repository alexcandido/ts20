package stepDefinitions;

import io.cucumber.java.en.Given;
import manager.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.LoginPageViaFacebook;
import pages.LoginPageViaSubmarino;
import pages.SubmarinoMainPage;
import util.Constants;


public class PerformLogin {

    private WebDriver driver = DriverFactory.getDriver();
    private WebDriverWait wait = DriverFactory.getWait();
    private SubmarinoMainPage submarinoMainPage;
    private LoginPageViaSubmarino loginPageViaSubmarino;
    private LoginPageViaFacebook loginPageViaFacebook;

    @Given("o usuário está logado no portal")
    public void performLogin() throws InterruptedException {
        submarinoMainPage = new SubmarinoMainPage(driver);
        loginPageViaSubmarino = new LoginPageViaSubmarino(driver);
        loginPageViaFacebook = new LoginPageViaFacebook(driver);

        submarinoMainPage.accessPage();
        submarinoMainPage.clickLogin();
        submarinoMainPage.clickLoginDefault();

        loginPageViaFacebook.performLogin(Constants.SUBMARINO_ACCOUNT, Constants.SUBMARINO_PASSWORD);

    }
}
