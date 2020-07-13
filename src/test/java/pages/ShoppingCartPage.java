package pages;

import manager.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.CommonActions;

public class ShoppingCartPage {

    private WebDriver driver;
    private CommonActions commonActions;
    private WebDriverWait wait;

    public ShoppingCartPage(WebDriver driver) {
        this.driver = driver;
        wait = DriverFactory.getWait();
        commonActions = new CommonActions(driver);
    }

}
