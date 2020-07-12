package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import manager.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.SubmarinoMainPage;
import pages.UserRegisterFormPage;
import util.CommonActions;

import static org.junit.Assert.assertEquals;

public class ValidateWrongEmail {

    private WebDriver driver = DriverFactory.getDriver();
    private WebDriverWait wait = DriverFactory.getWait();
    private SubmarinoMainPage submarinoMainPage;
    private UserRegisterFormPage userRegisterFormPage;
    private CommonActions commonActions;

    @Given("o usuário está na tela de cadastro")
    public void goToRegisterScreen() {
        submarinoMainPage = new SubmarinoMainPage(driver);
        userRegisterFormPage = new UserRegisterFormPage(driver);
        commonActions = new CommonActions(driver);

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
    public void userNotRegistered() {
        commonActions.waitForAnElementBeVisible(userRegisterFormPage.PAGE_TITLE);
    }

    @Then("o sistema não sai da tela de cadastro")
    public void stayOnRegisterScreen() {
        String expectedMsg = "Cadastre-se";
        String actualMsg = commonActions.elementText(userRegisterFormPage.PAGE_TITLE);

        assertEquals(expectedMsg, actualMsg);
    }
}
