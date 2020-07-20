package stepDefinitions;

import io.cucumber.java.en.Given;
import manager.DriverFactory;
import org.openqa.selenium.WebDriver;
import pages.LoginPageViaFacebook;
import pages.SubmarinoMainPage;
import util.Constants;


public class PerformLogin {

    private WebDriver driver = DriverFactory.getDriver();
    private SubmarinoMainPage submarinoMainPage = new SubmarinoMainPage(driver);
    private LoginPageViaFacebook loginPageViaFacebook = new LoginPageViaFacebook(driver);

    @Given("o usuário está logado no portal")
    public void performLogin() throws InterruptedException {

        submarinoMainPage.accessPage();
        submarinoMainPage.clickLogin();
        submarinoMainPage.clickLoginDefault();

        loginPageViaFacebook.performLogin(Constants.SUBMARINO_ACCOUNT, Constants.SUBMARINO_PASSWORD);

    }
}
