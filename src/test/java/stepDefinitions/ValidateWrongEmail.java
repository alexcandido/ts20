package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import manager.DriverFactory;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.SubmarinoMainPage;
import pages.UserRegisterFormPage;


public class ValidateWrongEmail {

    private WebDriver driver = DriverFactory.getDriver();
    private SubmarinoMainPage submarinoMainPage = new SubmarinoMainPage(driver);
    private UserRegisterFormPage userRegisterFormPage = new UserRegisterFormPage(driver);

    @Given("o usuário está na tela de cadastro")
    public void goToRegisterScreen() {
        submarinoMainPage.accessPage();
        submarinoMainPage.clickLogin();
        submarinoMainPage.openNewUserForm();
    }

    @Given("o usuário informa {string} inválido")
    public void typeInvalidEmail(String email) {
        userRegisterFormPage.setEmailField(email);
    }

    @Given("o usuário preenche os demais campos corretamente")
    public void typeValidData() {
        userRegisterFormPage.setPasswordField("abcD123_E");
        userRegisterFormPage.setCpfField("994.672.620-37");
        userRegisterFormPage.setNameField("Testes de Sistemas");
        userRegisterFormPage.setBirthdayField("10/10/1983");
        userRegisterFormPage.selectGender("M");
        userRegisterFormPage.setPhoneField("81999999999");
    }

    @When("o usuário clicar no botão cadastrar")
    public void clickSubmitOnRegisterScreen() {
        userRegisterFormPage.clickSubmitButton();
    }

    @Then("o cadastro não é realizado")
    public void stayOnRegisterScreen() {
        String expectedMsg = "Cadastre-se";
        String actualMsg = userRegisterFormPage.getPageTitle();

        Assert.assertEquals("A mensagem não foi a esperada!", expectedMsg, actualMsg);
    }
}
