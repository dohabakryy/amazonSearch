package testt;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class SearchPhones {


     WebDriver driver;
    WebDriverWait wait;
    @BeforeTest
    public void setUp()
    {
        // Set up ChromeDriver
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    }


       @Test(dataProvider ="phones-data",dataProviderClass = GetExcelData.class)
    public void searchPhones(String searchInput , String Brand)
    {
        driver.get("https://www.amazon.eg/");


        // Search for "phones"
        WebElement searchBox = wait.until(ExpectedConditions.elementToBeClickable(By.id("twotabsearchtextbox")));
        searchBox.sendKeys(searchInput);
        searchBox.submit();
        // Click on see more
        WebElement seeMore= driver.findElement(By.xpath("//*[contains(@id,'brandsRefinements')]//*[contains(@class,'a-expander-prompt')]"));
        seeMore.click();
        // Filter by brand
        WebElement brandF = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(@id,'p_89/"+Brand+"')]//*[contains(@class,'a-icon a-icon-checkbox')]")));
        brandF.click();

    }
    @AfterTest
    public void close()
    {driver.close();
        driver.quit();

    }
}