package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class resultPage {
    WebDriver driver;
    WebDriverWait wait;

    public resultPage (WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    By seeMore = By.xpath("//*[contains(@id,'brandsRefinements')]//*[contains(@class,'a-expander-prompt')]");


    public WebElement seeMoreButton() {
        return wait.until(ExpectedConditions.visibilityOf(driver.findElement(seeMore)));
    }

    public void selectBrand(String Brand) {

        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//*[contains(@id,'p_89/" + Brand + "')]//*[contains(@class,'a-icon a-icon-checkbox')]")))).click();
    }
   /* public List<String> getSearchResults() {
        List<WebElement> resultElements = driver.findElements(By.xpath("//div[@class='a-section a-spacing-none a-spacing-top-small s-title-instructions-style']"));
        List<String> searchResults = new ArrayList<>();

        for (WebElement resultElement : resultElements) {
            String resultText = resultElement.getText();
            searchResults.add(resultText);
        }

        return searchResults; */
    }


