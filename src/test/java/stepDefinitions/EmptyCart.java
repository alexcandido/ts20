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

public class EmptyCart {

    private WebDriver driver = DriverFactory.getDriver();
    private WebDriverWait wait = DriverFactory.getWait();
    private SubmarinoMainPage submarinoMainPage;
    private ProductPage productPage;
    private ShoppingCartPage shoppingCartPage;
    private CommonActions commonActions;

    @Given("o usuário possui um item no carrinho")
    public void goToCartWithItem() {
        submarinoMainPage = new SubmarinoMainPage(driver);
        productPage = new ProductPage(driver);
        shoppingCartPage = new ShoppingCartPage(driver);
        commonActions = new CommonActions(driver);

        submarinoMainPage.accessPage();
        submarinoMainPage.fillSearchBarAndPressEnter("Cartão psn");
        productPage.clickOnPsnCard();
        productPage.clickToBuy();
        submarinoMainPage.accessPage();
        submarinoMainPage.goToShoppingCart();
        shoppingCartPage.findPageTitle();
    }

    @When("o usuário clicar no botão remover")
    public void clickToRemoveItem() {
        commonActions.click(shoppingCartPage.REMOVE_BTN);
    }

    @Then("o produto é removido do carrinho")
    public void waitProductRemovedFromCart() {
        commonActions.waitForAnElementBeVisible(shoppingCartPage.EMPTY_CART_MSG);
    }

    @Then("o carrinho fica vazio")
    public void checkCartIsEmpty() {
        String actualMsg = commonActions.getElementText(shoppingCartPage.EMPTY_CART_MSG);

        assertEquals("Seu carrinho está vazio", actualMsg);
    }
}
