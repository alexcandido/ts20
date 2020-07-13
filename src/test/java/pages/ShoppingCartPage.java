package pages;

import manager.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.CommonActions;

public class ShoppingCartPage {

    private WebDriver driver;
    private CommonActions commonActions;
    private WebDriverWait wait;

    public static final By CART_TITLE = By.cssSelector(".basket-title .page-title");
    public static final By PRODUCT_IN_CART = By.cssSelector(".basket-productTitle [title='Gift Card Digital Playstation Store R$ 100']");
    public static final By PRODUCT_AMOUNT = By.xpath("//span[contains(text(),'1 produto')]");
    public static final By REMOVE_BTN = By.cssSelector(".basket-productRemoveAct.--desktop");
    public static final By EMPTY_CART_MSG = By.cssSelector(".basket-empty h2");

    public ShoppingCartPage(WebDriver driver) {
        this.driver = driver;
        wait = DriverFactory.getWait();
        commonActions = new CommonActions(driver);
    }

    public void findPageTitle() {
        commonActions.findElement(CART_TITLE);
    }

}
