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


public class AddItemToCart {

    private WebDriver driver = DriverFactory.getDriver();
    private WebDriverWait wait = DriverFactory.getWait();
    private ProductPage productPage;
    private ShoppingCartPage shoppingCartPage;


    @Given("o usuário seleciona o cartão da psn de R$100")
    public void selectItem() {
        productPage = new ProductPage(driver);
        productPage.clickOnPsnCard();
    }

    @When("o usuário clicar no botão comprar")
    public void addToCard() {
        productPage.clickToBuy();
    }

    @Then("o produto é adicionado ao carrinho")
    public void checkAddedProduct() {
        shoppingCartPage = new ShoppingCartPage(driver);

        shoppingCartPage.findPageTitle();

        String product = shoppingCartPage.getProductInCart();

        Assert.assertEquals("O produto não foi adicionado!","Gift Card Digital Playstation Store R$ 100", product);
    }

    @Then("a quantidade é atualizada para 1")
    public void checkAmount() {
        String amount = shoppingCartPage.getProductAmount();

        Assert.assertEquals("Quantidade errada!" ,"1 produto", amount);
    }

}
