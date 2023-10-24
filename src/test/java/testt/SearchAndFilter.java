package testt;

import Pages.homePage;
import Pages.resultPage;
import org.apache.xmlbeans.GDuration;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.List;


public class SearchAndFilter extends BaseTest {


    WebDriver driver;
    WebDriverWait wait;
    homePage homePage;
    resultPage resultPage;
    SoftAssert softAssert;

    @BeforeMethod
    public void setUp() {
        driver = driverHandler.getDriver();
        homePage = new homePage(driver);
        resultPage = new resultPage(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        softAssert = new SoftAssert();


    }


    @Test(dataProvider = "search-data", dataProviderClass = GetExcelData.class)
    public void searchProducts(String searchInput, String Brand) {


        homePage.searchButton().clear();


        // Search for product
        homePage.searchButton().sendKeys(searchInput);
        homePage.searchButton().submit();
        // click on see more
        resultPage.seeMoreButton();

        // filter by brand
        resultPage.selectBrand(Brand);

        //Assertions
        softAssert.assertEquals(resultPage.getActualSearchWord(), searchInput);
        softAssert.assertAll();
    }
}

