package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class P01_HomePage {
    WebDriver driver;

    public P01_HomePage (WebDriver driver)
    {
        this.driver = driver;
    }
   private By searchField =By.id("twotabsearchtextbox");

    public WebElement searchButton ()
    {
        return driver.findElement(searchField);
    }
}
