package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;


public class resultPage {
    WebDriver driver;
    WebDriverWait wait;

    public resultPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    By seeMore = By.xpath("//*[contains(@id,'brandsRefinements')]//*[contains(@class,'a-expander-prompt')]");
    By actualSearchWord = By.xpath("//span[@class='a-color-state a-text-bold']");

    public void seeMoreButton() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(seeMore))).click();
        } catch (NoSuchElementException e) {
            System.out.println("Element not found, skipping");
        }
    }

    public String getActualSearchWord() {

       String text1 = driver.findElement(actualSearchWord).getText();
       return text1.replaceAll("\"","");

    }

    public void selectBrand(String Brand) {

        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//*[contains(@id,'p_89/" + Brand + "')]//*[contains(@class,'a-icon a-icon-checkbox')]")))).click();
    }


}



