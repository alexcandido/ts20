package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import manager.DriverFactory;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.ProductPage;
import pages.ShoppingCartPage;
import pages.SubmarinoMainPage;
import util.CommonActions;


public class EmptyCart {

    private WebDriver driver = DriverFactory.getDriver();
    private WebDriverWait wait = DriverFactory.getWait();
    private SubmarinoMainPage submarinoMainPage = new SubmarinoMainPage(driver);
    private ProductPage productPage = new ProductPage(driver);
    private ShoppingCartPage shoppingCartPage = new ShoppingCartPage(driver);
    private CommonActions commonActions = new CommonActions(driver);

    @Given("o usuário possui um item no carrinho")
    public void goToCartWithItem() {
        submarinoMainPage.fillSearchBarAndPressEnter("Cartão psn");
        productPage.clickOnPsnCard();
        productPage.clickToBuy();
        submarinoMainPage.accessPage();
        submarinoMainPage.goToShoppingCart();
        shoppingCartPage.findPageTitle();
    }

    @When("o usuário clicar no botão remover")
    public void clickToRemoveItem() { shoppingCartPage.clickRemoveBtn(); }

    @Then("o carrinho fica vazio após remover o produto")
    public void checkCartIsEmpty() {
        String actualMsg = shoppingCartPage.getEmptyCartMsg();

        Assert.assertEquals("A mensagem não foi a esperada!","Seu carrinho está vazio", actualMsg);
    }
}
