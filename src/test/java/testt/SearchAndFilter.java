package testt;

import Pages.homePage;
import Pages.resultPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SearchAndFilter extends BaseTest {


    WebDriver driver;
    homePage homePage;
    resultPage resultPage;
    SoftAssert softAssert;

    @BeforeMethod
    public void setUp() {
        driver = driverHandler.getDriver();
        homePage = new homePage(driver);
        resultPage = new resultPage(driver);
        softAssert = new SoftAssert();


    }
    @Test
    public void dummyTest() {
        homePage.searchButton().sendKeys("HIIIIIII");
        System.out.println(">>> Dummy test executed <<<");
    }

//    @Test(dataProvider = "search-data", dataProviderClass = GetExcelData.class)
//    public void searchProducts(String searchInput, String Brand) {
//
//
//        homePage.searchButton().clear();
//
//
//        // Search for product
//        homePage.searchButton().sendKeys(searchInput);
//        homePage.searchButton().submit();
//        // click on see more
//        resultPage.seeMoreButton();
//
//        // filter by brand
//        resultPage.selectBrand(Brand);
//
//        //Assertions
//        softAssert.assertEquals(resultPage.getActualSearchWord(), searchInput);
//        softAssert.assertAll();
//    }
}

