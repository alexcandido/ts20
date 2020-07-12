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
    public void o_usuário_está_na_tela_de_cadastro() {
        submarinoMainPage = new SubmarinoMainPage(driver);
        userRegisterFormPage = new UserRegisterFormPage(driver);
        commonActions = new CommonActions(driver);

        submarinoMainPage.accessPage();
        submarinoMainPage.clickLogin();
        submarinoMainPage.openNewUserForm();
    }

    @Given("o usuário informa {string} inválido")
    public void o_usuário_informa_email_inválido(String email) {
        userRegisterFormPage.setEmailField(email);
    }

    @Given("o usuário preenche os demais campos corretamente")
    public void o_usuário_preenche_os_demais_campos_corretamente() {
        userRegisterFormPage.setPasswordField("abcD123_E");
        userRegisterFormPage.setCpfField("994.672.620-37");
        userRegisterFormPage.setNameField("Testes de Sistemas");
        userRegisterFormPage.setBirthdayField("10/10/1983");
        userRegisterFormPage.selectGender("M");
        userRegisterFormPage.setPhoneField("81999999999");
    }

    @When("o usuário clicar no botão cadastrar")
    public void o_usuário_clicar_no_botão_cadastrar() {
        userRegisterFormPage.clickSubmitButton();
    }

    @Then("o cadastro não é realizado")
    public void o_cadastro_não_é_realizado() {
        commonActions.waitForAnElementBeVisible(userRegisterFormPage.PAGE_TITLE);
    }

    @Then("o sistema não sai da tela de cadastro")
    public void o_sistema_não_sai_da_tela_de_cadastro() {
        String expectedMsg = "Cadastre-se";
        String actualMsg = commonActions.elementText(userRegisterFormPage.PAGE_TITLE);

        assertEquals(expectedMsg, actualMsg);
    }
}
