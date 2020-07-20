package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import manager.DriverFactory;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.ProductPage;
import pages.SearchPage;
import pages.ShoppingCartPage;
import pages.SubmarinoMainPage;


public class EmptyCart {

    private WebDriver driver = DriverFactory.getDriver();
    private SubmarinoMainPage submarinoMainPage = new SubmarinoMainPage(driver);
    private SearchPage searchPage = new SearchPage(driver);
    private ProductPage productPage = new ProductPage(driver);
    private ShoppingCartPage shoppingCartPage = new ShoppingCartPage(driver);

    @Given("o usuário possui um item no carrinho")
    public void addItemToShoppingCart() {
        submarinoMainPage.accessPage();
        submarinoMainPage.fillSearchBarAndPressEnter("Cartão psn");
        searchPage.clickOnFoundItem();
        productPage.clickToBuy();
    }

    @Given("o usuário abre o carrinho")
    public void openTheShoppingCart(){
        submarinoMainPage.accessPage();
        submarinoMainPage.goToShoppingCart();
        shoppingCartPage.findPageTitle();
    }

    @When("o usuário clicar no botão remover")
    public void clickToRemoveItem() {
        shoppingCartPage.clickRemoveBtn();
    }

    @Then("o carrinho fica vazio após remover o produto")
    public void checkCartIsEmpty() {
        String actualMsg = shoppingCartPage.getEmptyCartMsg();

        Assert.assertEquals("A mensagem não foi a esperada!", "Seu carrinho está vazio", actualMsg);
    }
}
