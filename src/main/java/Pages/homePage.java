package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class homePage {
    WebDriver driver;

    public homePage(WebDriver driver) {

        this.driver = driver;
    }

    private By searchField = By.id("twotabsearchtextbox");

    public WebElement searchButton() {
           return driver.findElement(searchField);

    }
}
