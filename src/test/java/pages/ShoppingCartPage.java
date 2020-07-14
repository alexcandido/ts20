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

    private By cartTitle = By.cssSelector(".basket-title .page-title");
    private By productInCart = By.cssSelector(".basket-productTitle [title='Gift Card Digital Playstation Store R$ 100']");
    private By productAmount = By.xpath("//span[contains(text(),'1 produto')]");
    private By removeBtn = By.cssSelector(".basket-productRemoveAct.--desktop");
    private By emptyCartMsg = By.cssSelector(".basket-empty h2");

    public ShoppingCartPage(WebDriver driver) {
        this.driver = driver;
        wait = DriverFactory.getWait();
        commonActions = new CommonActions(driver);
    }

    public void findPageTitle() {
        commonActions.findElement(cartTitle);
    }

    public void clickRemoveBtn() { commonActions.click(removeBtn); }

    public String getEmptyCartMsg() {
        commonActions.waitForAnElementBeVisible(emptyCartMsg);
        return commonActions.getElementText(emptyCartMsg);
    }

    public String getProductInCart() {
        commonActions.waitForAnElementBeVisible(productInCart);
        return commonActions.getElementText(productInCart);
    }

    public String getProductAmount() {
        commonActions.waitForAnElementBeVisible(productAmount);
        return commonActions.getElementText(productAmount);
    }

}
