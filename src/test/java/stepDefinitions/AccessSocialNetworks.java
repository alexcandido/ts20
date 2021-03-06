package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import manager.DriverFactory;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.SocialNetworksPage;
import pages.SubmarinoMainPage;
import util.CommonActions;


public class AccessSocialNetworks {

    private WebDriver driver = DriverFactory.getDriver();
    private SubmarinoMainPage submarinoMainPage = new SubmarinoMainPage(driver);
    private SocialNetworksPage socialNetworksPage = new SocialNetworksPage(driver);
    private CommonActions commonActions = new CommonActions(driver);


    @When("o usuário clicar no icone da {string}")
    public void clickSocialNetworkIcon(String social) {

        // Store the current window handle
        String winHandleBefore = driver.getWindowHandle();

        submarinoMainPage.clickSocialIcon(social);

        // Switch to new window opened
        for (String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle);
        }

        socialNetworksPage.waitLogoLoaded(social);
    }

    @Then("a {string} da rede social selecionada irá abrir")
    public void checkSelectedSocialNetwork(String message) {
        String actualMsg = commonActions.getCurrentlyUrl();

        Assert.assertEquals("Rede Social não encontrada", message, actualMsg);
    }
}
