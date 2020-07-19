package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import manager.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.ProductPage;

public class ValidateShippingAndTime {

    private WebDriver driver = DriverFactory.getDriver();
    private WebDriverWait wait = DriverFactory.getWait();

    private ProductPage productPage = new ProductPage(driver);

    @When("o usuário informar o CEP {string}")
    public void fillShippingField(String zip) {
        productPage.fillZipCode(zip);
    }

    @Then("o portal lista o frete e o prazo convencional")
    public void verifyShippingAndTime(){
        
    }
}
