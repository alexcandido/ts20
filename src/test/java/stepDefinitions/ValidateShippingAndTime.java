package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import manager.DriverFactory;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.ProductPage;

public class ValidateShippingAndTime {

    private WebDriver driver = DriverFactory.getDriver();
    private ProductPage productPage = new ProductPage(driver);

    @When("o usuário informar o CEP {string}")
    public void fillShippingField(String zip) {
        productPage.fillZipCode(zip);
    }

    @Then("o portal lista a tabela do tipo, preço e prazo do frete")
    public void verifyShippingAndTime() {
        Assert.assertTrue("Tabela de frete não exibida", productPage.isShippingTableDisplayed());
    }
}
