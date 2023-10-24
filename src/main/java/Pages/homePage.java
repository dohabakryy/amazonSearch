package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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
