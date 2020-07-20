package pages;

import manager.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.CommonActions;
import util.Constants;

public class LoginPageViaFacebook {

    private WebDriver driver;
    private WebDriverWait wait;
    private CommonActions commonActions;
    private SubmarinoMainPage submarinoMainPage;

    private By fbLogInElement = By.cssSelector(".fb-login-button.fb_iframe_widget");
    private By fbLogInBtn = By.cssSelector(".facebookLogin-btnHover");

    private By fbEmailInput = By.cssSelector("#email");
    private By fbPasswordInput = By.cssSelector("#pass");
    private By fbLoginBtn = By.cssSelector("#loginbutton");

    public LoginPageViaFacebook(WebDriver driver) {
        this.driver = driver;
        wait = DriverFactory.getWait();
        commonActions = new CommonActions(driver);
        submarinoMainPage = new SubmarinoMainPage(driver);
    }

    public void fillEmail(String email) {
        commonActions.setElementValue(fbEmailInput, email);
    }

    public void fillPassword(String password) {
        commonActions.setElementValue(fbPasswordInput, password);
    }

    public void clickLogin() throws InterruptedException {
        commonActions.click(fbLoginBtn);
        Thread.sleep(6000);
    }

    public void performLogin(String emailAccount, String password) throws InterruptedException {
        commonActions.waitForAnElementBeVisible(fbLogInElement);

        // Store the current window handle
        String winHandleBefore = driver.getWindowHandle();

        // Perform the click operation that opens new window
        driver.findElement(fbLogInBtn).click();

        // Switch to new window opened
        for (String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle);
        }

        // Perform the actions on new window
        fillEmail(emailAccount);
        fillPassword(password);
        clickLogin();

        // Switch back to previous window context
        driver.switchTo().window(winHandleBefore);

        wait.until(ExpectedConditions.textToBePresentInElementLocated(submarinoMainPage.getUserNameSelector(), Constants.ACCOUNT_FIRST_NAME));
    }
}
