package testt;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import utilities.DriverHandler;


public class BaseTest {

    public DriverHandler driverHandler;

    @BeforeSuite

    public void setUpp() {
        driverHandler = new DriverHandler();
        driverHandler.createDriver();
        driverHandler.openAmazon();

    }


    public WebDriver getDriver() {
        return driverHandler.getDriver();
    }

    @AfterSuite
    public void tearDown() {
        driverHandler.getDriver().quit();
    }
}
