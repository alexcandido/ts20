package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import manager.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.ProductPage;
import pages.ShoppingCartPage;
import pages.SubmarinoMainPage;
import util.CommonActions;

import static org.junit.Assert.assertEquals;

public class AddItemToCart {

    private WebDriver driver = DriverFactory.getDriver();
    private WebDriverWait wait = DriverFactory.getWait();
    private SubmarinoMainPage submarinoMainPage;
    private ProductPage productPage;
    private ShoppingCartPage shoppingCartPage;
    private CommonActions commonActions;

    @Given("o usuário encontra um produto desejado")
    public void findItem() {
        submarinoMainPage = new SubmarinoMainPage(driver);
        productPage = new ProductPage(driver);
        shoppingCartPage = new ShoppingCartPage(driver);
        commonActions = new CommonActions(driver);

        submarinoMainPage.accessPage();
        submarinoMainPage.fillSearchBarAndPressEnter("Cartão psn");
        productPage.clickOnPsnCard();
    }

    @When("o usuário clicar no botão comprar")
    public void addToCard() {
        productPage.clickToBuy();
    }

    @Then("o produto é adicionado ao carrinho")
    public void checkAddedProduct() {
        shoppingCartPage.findPageTitle();

        String product = shoppingCartPage.getProductInCart();

        assertEquals("Gift Card Digital Playstation Store R$ 100", product);
    }

    @Then("a quantidade é atualizada para 1")
    public void checkAmount() {
        String amount = shoppingCartPage.getProductAmount();

        assertEquals("1 produto", amount);
    }

}
