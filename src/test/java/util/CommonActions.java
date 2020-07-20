package util;

import manager.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class CommonActions {

    private WebDriver driver;
    private WebDriverWait wait;

    public CommonActions(WebDriver driver) {
        this.driver = driver;
        wait = DriverFactory.getWait();
    }

    public void setElementValue(By locator, String value) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(value);
    }

    public void sendKeys(By locator, Keys keys) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        driver.findElement(locator).sendKeys(keys);
    }

    public void click(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator));
        driver.findElement(locator).click();
    }

    public WebElement findElement(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return driver.findElement(locator);
    }

    public List<WebElement> findElements(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return driver.findElements(locator);
    }

    public void waitForAnElementBeVisible(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public String getElementText(By locator) {
        WebElement element = driver.findElement(locator);
        return element.getText().trim();
    }

    public String getCurrentlyUrl() {
        return driver.getCurrentUrl();
    }

    public By getXpathSelectorModifiedByRegex(String selectorString, String value) {
        return By.xpath(selectorString.replace("%s", value));
    }

    public By getCssSelectorModifiedByRegex(String selectorString, String value) {
        return By.cssSelector(selectorString.replace("%s", value));
    }
}
