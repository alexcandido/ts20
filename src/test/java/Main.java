import manager.DriverFactory;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.Constants;

public class Main {

    public static WebDriver driver = DriverFactory.getDriver();
    public static WebDriverWait wait = DriverFactory.getWait();

    @Test
    public void sampleTest() {

        // Setup
        //MainPage mainPage = new MainPage(driver);
        String expectedTableTitle = "Table Sort And Search Demo";

        // Given
        //mainPage.accessPage();
        driver.get(Constants.SUBMARINO_MAIN_URL);

        // When


        // Then


        // End session
        DriverFactory.endSession();
    }
}
