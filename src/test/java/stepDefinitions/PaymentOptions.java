package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import manager.DriverFactory;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.ProductPage;

import java.util.Arrays;
import java.util.List;

public class PaymentOptions {
    private WebDriver driver = DriverFactory.getDriver();
    private ProductPage productPage = new ProductPage(driver);

    @When("o usuário abre as opções de pagamento")
    public void openPaymentOptions() {
        productPage.openPaymentOptions();
    }

    @Then("o portal lista as formas de pagamento disponíveis")
    public void validatePaymentOptions() {
        List<String> expectedPaymentOptionsList = Arrays.asList("Cartão de crédito", "Submarino", "Boleto bancário", "Ame");
        List<WebElement> actualPaymentOptionList = productPage.getPaymentOptionsList();

        for (int i = 0; i < actualPaymentOptionList.size(); i++) {
            Assert.assertEquals("Payment option wrong!", expectedPaymentOptionsList.get(i), actualPaymentOptionList.get(i).getText());
        }
    }
}
