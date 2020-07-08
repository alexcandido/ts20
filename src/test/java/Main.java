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

        // Given
        driver.get(Constants.SUBMARINO_MAIN_URL);

        // When

        // Then

        // End session
        DriverFactory.endSession();
    }
}
