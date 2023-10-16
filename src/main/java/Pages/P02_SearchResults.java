package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class P02_SearchResults {
    WebDriver driver;
    public P02_SearchResults (WebDriver driver)
    {
        this.driver= driver;

    }

    By seeMore = By.xpath("//*[contains(@id,'brandsRefinements')]//*[contains(@class,'a-expander-prompt')]");


public WebElement seeMoreButton (){
    return driver.findElement(seeMore);
}

    public void selectBrand(String Brand) {

        driver.findElement(By.xpath("//*[contains(@id,'p_89/" + Brand + "')]//*[contains(@class,'a-icon a-icon-checkbox')]")).click();
    }}

