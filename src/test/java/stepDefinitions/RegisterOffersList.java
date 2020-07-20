package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import manager.DriverFactory;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.SubmarinoMainPage;
import util.Constants;


public class RegisterOffersList {

    private WebDriver driver = DriverFactory.getDriver();
    private WebDriverWait wait = DriverFactory.getWait();
    private SubmarinoMainPage submarinoMainPage;


    @When("o usuário digitar seu e-mail na lista de ofertas")
    public void typeValidEmailOnOffersField() {
        submarinoMainPage = new SubmarinoMainPage(driver);

        submarinoMainPage.setEmailField(Constants.SUBMARINO_ACCOUNT);
    }

    @When("o usuário selecionar o botão cadastrar")
    public void selectCadastrasButton() {
        submarinoMainPage.clickSubmitBtn();
    }

    @Then("o sistema retorna uma mensagem de sucesso informando que o usuário foi cadastrado na lista de ofertas")
    public void checkSuccessMsg() {
        String expectedMsg = "Seu e-mail foi cadastrado com sucesso!";
        String actualMsg = submarinoMainPage.getSuccessMessage();

        Assert.assertEquals("A mensagem não foi a esperada!", expectedMsg, actualMsg);
    }
}
