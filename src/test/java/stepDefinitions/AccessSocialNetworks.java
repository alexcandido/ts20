package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import manager.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.SubmarinoMainPage;
import util.CommonActions;

import static org.junit.Assert.assertEquals;

public class AccessSocialNetworks {

    private WebDriver driver = DriverFactory.getDriver();
    private WebDriverWait wait = DriverFactory.getWait();
    private SubmarinoMainPage submarinoMainPage;
    private CommonActions commonActions;

    @Given("o usuário está na página principal do submarino")
    public void goToMainPage() {
        submarinoMainPage = new SubmarinoMainPage(driver);
        commonActions = new CommonActions(driver);

        submarinoMainPage.accessPage();
    }

    @When("o usuário clicar no icone da {string}")
    public void clickSocialNetworkIcon(String social) {
        // Store the current window handle
        String winHandleBefore = driver.getWindowHandle();

        if (social.equals("youtube")) {
            commonActions.click(submarinoMainPage.YOUTUBE_ICN);
        } else if (social.equals("facebook")) {
            commonActions.click(submarinoMainPage.FACEBOOK_ICN);
        } else if (social.equals("instagram")) {
            commonActions.click(submarinoMainPage.INSTAGRAM_ICN);
        } else if (social.equals("twitter")) {
            commonActions.click(submarinoMainPage.TWITTER_ICN);
        }

        // Switch to new window opened
        for(String winHandle : driver.getWindowHandles()){
            driver.switchTo().window(winHandle);
        }
    }

    @Then("a {string} da rede social selecionada irá abrir")
    public void checkSelectedSocialNetwork(String message) {
        String expectedMsg = message;
        String actualMsg = commonActions.getCurrentlyUrl();

        assertEquals(expectedMsg, actualMsg);
    }
}
