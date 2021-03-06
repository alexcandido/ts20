package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import manager.DriverFactory;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.FavoritePage;
import pages.ProductPage;
import pages.SearchPage;
import pages.SubmarinoMainPage;

public class SearchForProduct {

    private WebDriver driver = DriverFactory.getDriver();
    private SubmarinoMainPage submarinoMainPage = new SubmarinoMainPage(driver);
    private SearchPage searchPage = new SearchPage(driver);
    private ProductPage productPage = new ProductPage(driver);
    private FavoritePage favoritePage = new FavoritePage(driver);

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
        Assert.assertEquals("O termo retornado nos termos relacionados é diferente do esperado", product, actualResult);

        actualResult = searchPage.getRelatedSearchTitle();
        Assert.assertEquals("O termo retornado no título da busca é diferente do esperado.", product, actualResult);

        int foundProductsNumber = searchPage.getItemsNumberOnGrid();
        Assert.assertTrue("O número de produtos encontrados é inválido", foundProductsNumber > 0);
    }

    @Given("o usuário seleciona um dos produtos listados")
    public void selectProduct() {
        searchPage.clickOnFoundItem();
    }

    @Given("o usuário seleciona o produto {string}")
    public void selecProductByName(String productName) {
        productPage.clickOnProductByName(productName);
    }

    @When("o usuário adiciona o item a lista de favoritos")
    public void addProductToFavoriteList() {
        productPage.addProductToFavoriteList();

    }

    @When("o usuário vai para a lista de favoritos")
    public void goToFavoriteList() {
        submarinoMainPage.openFavoriteWishList();
    }

    @Then("o portal lista o item adicionado {string}")
    public void checkItemOnWishList(String productName) {

        String actualResult = favoritePage.getProductName().toLowerCase();

        Assert.assertTrue("Produto não encontrado!", actualResult.contains(productName));

    }

    @When("o usuário remove os itens da lista de favoritos")
    public void clearWishList() {
        favoritePage.clearWishList();
    }

    @Then("o portal irá informar que a lista está vazia")
    public void showEmptyWishListMessage() {
        String expectedMessage = "Você não possui produtos salvos";
        Assert.assertEquals("Wrong message!", expectedMessage, favoritePage.getEmptyWishListMessage());
    }

}
