package testt;

import Pages.P01_HomePage;
import Pages.P02_SearchResults;
import org.apache.poi.util.SystemOutLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class SearchAndFilterTest {


    private WebDriver driver;
    private WebDriverWait wait;
    P01_HomePage homePage;
    P02_SearchResults resultPage;

    @BeforeTest
    public void setUp()
    {
        // Set up ChromeDriver
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--incognito");
        driver = new ChromeDriver(options);
        homePage = new P01_HomePage(driver);
        resultPage = new P02_SearchResults(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://www.amazon.eg/");

    }


    @Test(dataProvider ="search-data",dataProviderClass = GetExcelData.class)
    public void searchLaptops(String searchInput , String Brand )
    {

        homePage.searchButton().clear();


        // Search for product
        homePage.searchButton().sendKeys(searchInput);
        homePage.searchButton().submit();
        // click on see more
        resultPage.seeMoreButton().click();
        // filter by brand
        resultPage.selectBrand(Brand);



    }
@AfterTest
    public void close()
{

    driver.quit();

}
}