package pages;

import manager.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.CommonActions;

public class SocialNetworksPage {

    private WebDriver driver;
    private WebDriverWait wait;
    private CommonActions commonActions;

    private By youtubeLogo = By.cssSelector("#logo [title='Página inicial do YouTube']");
    private By facebookLogo = By.cssSelector("#blueBarDOMInspector [title='Ir para a página inicial do Facebook']");
    private By instagramLogo = By.cssSelector(".cq2ai [alt=Instagram]");
    private By twitterLogo = By.cssSelector("[aria-label=Twitter][role=button]");

    public SocialNetworksPage(WebDriver driver){
        this.driver = driver;
        commonActions = new CommonActions(driver);
        wait = DriverFactory.getWait();
    }

    public void waitLogoLoaded(String social) {
        if (social.equals("youtube")) {
            commonActions.waitForAnElementBeVisible(youtubeLogo);
        } else if (social.equals("facebook")) {
            commonActions.waitForAnElementBeVisible(facebookLogo);
        } else if (social.equals("instagram")) {
            commonActions.waitForAnElementBeVisible(instagramLogo);
        } else if (social.equals("twitter")) {
            commonActions.waitForAnElementBeVisible(twitterLogo);
        }
    }


}
