package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import manager.DriverFactory;
import org.openqa.selenium.WebDriver;


public class Hooks {

    private static WebDriver driver;

    @Before
    public void setUp() {
        System.out.println("BEFORE ALL EXECUTIONS: maximize the browser windows");
        driver = DriverFactory.getDriver();
        driver.manage().window().maximize();
    }

    @After
    public void tearDown() {
        System.out.println("AFTER ALL EXECUTIONS: close the browser window");
        DriverFactory.endSession();
    }

}