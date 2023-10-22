package testt;

import Pages.homePage;
import Pages.resultPage;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class WithoutBaseTest {


    private WebDriver driver;
    private WebDriverWait wait;
    Pages.homePage homePage;
    Pages.resultPage resultPage;

    @BeforeTest
    public void setUp()
    {
        // Set up ChromeDriver
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--incognito");
        driver = new ChromeDriver(options);
        homePage = new homePage(driver);
        resultPage = new resultPage(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://www.amazon.eg/");

    }


    @Test(dataProvider ="search-data",dataProviderClass = GetExcelData.class)
    public void searchProducts(String searchInput , String Brand )
    {

        homePage.searchButton().clear();


        // Search for product
        homePage.searchButton().sendKeys(searchInput);
        homePage.searchButton().submit();
        // click on see more
        try{
            wait.until(ExpectedConditions.elementToBeClickable(resultPage.seeMoreButton())).click();
        }
        catch (NoSuchElementException e)
        { System.out.println("Element not found, skipping");}
        // filter by brand
        resultPage.selectBrand(Brand);



    }
@AfterTest
    public void close()
{

    driver.quit();

}
}