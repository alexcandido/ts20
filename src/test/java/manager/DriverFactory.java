package manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DriverFactory {

    private static WebDriver driver;
    private static WebDriverWait wait;
    private static long defaultTimeout = 10;

    private static final String MAC_CHROME_DRIVER = "src/resources/chromedriver/macos/chromedriver";
    private static final String WINDOWS_CHROME_DRIVER = "src/resources/chromedriver/windows/chromedriver.exe";
    private static final String LINUX_CHROME_DRIVER = "src/resources/chromedriver/linux/chromedriver";

    public static WebDriver getDriver () {
        if(driver == null){
            System.setProperty("webdriver.chrome.driver", MAC_CHROME_DRIVER);
            //System.setProperty("webdriver.chrome.driver", WINDOWS_CHROME_DRIVER);
            //System.setProperty("webdriver.chrome.driver", LINUX_CHROME_DRIVER);
            driver = new ChromeDriver();
        }
        return driver;
    }

    public static WebDriverWait getWait (long defaultTimeout){
        if (wait == null){
            wait = new WebDriverWait(driver, defaultTimeout);
        }
        return wait;
    }

    public static WebDriverWait getWait (){
        if (wait == null){
            wait = new WebDriverWait(driver, defaultTimeout);
        }
        return wait;
    }

    public static void endSession (){
        if (driver != null) {
            driver.quit();
            wait = null;
            driver = null;
        }
    }
}
