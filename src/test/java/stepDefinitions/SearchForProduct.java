package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import manager.DriverFactory;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.LoginPageViaFacebook;
import pages.ProductPage;
import pages.SearchPage;
import pages.SubmarinoMainPage;

public class SearchForProduct {

    private WebDriver driver = DriverFactory.getDriver();
    private WebDriverWait wait = DriverFactory.getWait();

    private SubmarinoMainPage submarinoMainPage = new SubmarinoMainPage(driver);
    private LoginPageViaFacebook loginPageViaFacebook = new LoginPageViaFacebook(driver);
    private SearchPage searchPage = new SearchPage(driver);
    private ProductPage productPage = new ProductPage(driver);

    @Given("o usuário está na home page")
    public void navigateToHomePage() {
        submarinoMainPage.accessPage();
    }

    @Given("o usuário busca o produto {string} através da barra de busca")
    public void fill(String product) {
        submarinoMainPage.fillSearchBarAndPressEnter(product);
    }

    @Given("o portal irá listar produtos relacionados com o termo buscado {string}")
    public void listRelatedProducts(String product) {
        String actualResult = searchPage.getRelatedSearchTerm();
        Assert.assertEquals("The returned term is properly shown at term result.", product, actualResult);

        actualResult = searchPage.getRelatedSearchTitle();
        Assert.assertEquals("The returned term is properly shown at title result.", product, actualResult);

        int foundProductsNumber = searchPage.getItemsNumberOnGrid();
        Assert.assertTrue("The number of items found is positive.", foundProductsNumber > 0);
    }

    @Given("o usuário seleciona um dos produtos listados")
    public void selectProduct() {
        searchPage.clickOnFoundItem();
    }

    @When("o usuário adiciona o item a lista de favoritos")
    public void addProductToFavoriteList() {
        productPage.addProductToFavoriteList();

    }

    @When("o usuário vai para a lista de favoritos")
    public void goToFavoriteList() {
        submarinoMainPage.openFavoriteWishList();
    }
/*
    @Then("o portal lista o item adicionado {string}")
    public void o_portal_lista_o_item_adicionado(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Given("o usuário vai para a lista de favoritos")
    public void o_usuário_vai_para_a_lista_de_favoritos() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("o usuário remove os itens da lista de favoritos")
    public void o_usuário_remove_os_itens_da_lista_de_favoritos() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("o portal irá informar que a lista está vazia")
    public void o_portal_irá_informar_que_a_lista_está_vazia() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
*/
}
