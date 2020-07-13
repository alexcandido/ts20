package stepDefinitions;

import io.cucumber.java.en.Given;
import manager.DriverFactory;
import org.openqa.selenium.WebDriver;
import pages.LoginPageViaFacebook;
import pages.SubmarinoMainPage;
import util.Constants;


public class PerformLogin {

    private WebDriver driver = DriverFactory.getDriver();
    private SubmarinoMainPage submarinoMainPage;
    private LoginPageViaFacebook loginPageViaFacebook;

    @Given("o usuário está logado no portal")
    public void performLogin() throws InterruptedException {
        submarinoMainPage = new SubmarinoMainPage(driver);
        loginPageViaFacebook = new LoginPageViaFacebook(driver);

        submarinoMainPage.accessPage();
        submarinoMainPage.clickLogin();
        submarinoMainPage.clickLoginDefault();

        loginPageViaFacebook.performLogin(Constants.SUBMARINO_ACCOUNT, Constants.SUBMARINO_PASSWORD);

    }
}
