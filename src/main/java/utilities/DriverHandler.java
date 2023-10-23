package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverHandler {
    WebDriver driver;

    public void createDriver() {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--incognito");
        driver = new ChromeDriver(options);
    }
    public WebDriver getDriver() {
        return driver;
    }
    public void openAmazon() {
        driver.get("https://www.amazon.eg/?language=en_AE");
    }

}
