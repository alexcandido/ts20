package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import manager.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.SocialNetworksPage;
import pages.SubmarinoMainPage;
import util.CommonActions;

import static org.junit.Assert.assertEquals;

public class AccessSocialNetworks {

    private WebDriver driver = DriverFactory.getDriver();
    private WebDriverWait wait = DriverFactory.getWait();
    private SubmarinoMainPage submarinoMainPage;
    private SocialNetworksPage socialNetworksPage;
    private CommonActions commonActions;

    @Given("o usuário está na página principal do submarino")
    public void goToMainPage() {
        submarinoMainPage = new SubmarinoMainPage(driver);
        socialNetworksPage = new SocialNetworksPage(driver);
        commonActions = new CommonActions(driver);

        submarinoMainPage.accessPage();
    }

    @When("o usuário clicar no icone da {string}")
    public void clickSocialNetworkIcon(String social) {
        // Store the current window handle
        String winHandleBefore = driver.getWindowHandle();

        submarinoMainPage.clickSocialIcon(social);

        // Switch to new window opened
        for(String winHandle : driver.getWindowHandles()){
            driver.switchTo().window(winHandle);
        }

        socialNetworksPage.waitLogoLoaded(social);
    }

    @Then("a {string} da rede social selecionada irá abrir")
    public void checkSelectedSocialNetwork(String message) {
        String actualMsg = commonActions.getCurrentlyUrl();

        assertEquals(message, actualMsg);
    }
}
