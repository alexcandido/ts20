package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import manager.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.SubmarinoMainPage;
import util.CommonActions;
import util.Constants;

import static org.junit.Assert.assertEquals;

public class RegisterOffersList {

    private WebDriver driver = DriverFactory.getDriver();
    private WebDriverWait wait = DriverFactory.getWait();
    private SubmarinoMainPage submarinoMainPage;
    private CommonActions commonActions;

    @Given("o usuário está na home page do submarino")
    public void goToMain() {
        submarinoMainPage = new SubmarinoMainPage(driver);
        commonActions = new CommonActions(driver);

        submarinoMainPage.accessPage();
    }

    @When("o usuário digitar seu e-mail na lista de ofertas")
    public void typeValidEmailOnOffersField() {
        submarinoMainPage.setEmailField(Constants.SUBMARINO_ACCOUNT);
    }

    @When("o usuário selecionar o botão cadastrar")
    public void selectCadastrasButton() {
        submarinoMainPage.clickSubmitBtn();
    }

    @Then("o sistema irá cadastrar o usuário na lista de ofertas")
    public void userRegisteredSuccess() {
        commonActions.waitForAnElementBeVisible(submarinoMainPage.SUCCESS_MESSAGE);
    }

    @Then("o sistema irá retornar uma mensgem de sucesso")
    public void checkSuccessMsg() {
        String expectedMsg = "Seu e-mail foi cadastrado com sucesso!";
        String actualMsg = commonActions.getElementText(submarinoMainPage.SUCCESS_MESSAGE);

        assertEquals(expectedMsg, actualMsg);
    }
}
