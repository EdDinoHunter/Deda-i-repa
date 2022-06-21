package pages;

import java.time.Duration;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class BasePage {
    public WebDriver driver;
    public WebDriverWait wait;
    
    public BasePage (WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void waitVisibility (By elementBy){
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(elementBy));
    }

    public void click (By elementBy){
        wait.until(ExpectedConditions.elementToBeClickable(elementBy));
        driver.findElement(elementBy).click();
    }

    public void writeText (By elementBy, String text){
        waitVisibility(elementBy);
        driver.findElement(elementBy).clear();
        driver.findElement(elementBy).sendKeys(text);
    }

    public String readText (By errorMessageBy){
        waitVisibility(errorMessageBy);
        return driver.findElement(errorMessageBy).getText();
    }

    public void assertStringEquals (String string, String expectedText){
        Assert.assertEquals(string, expectedText);
    }

    public void assertIntegerEquals(int expectedNumber, int actualNumber){
    Assert.assertEquals(expectedNumber, actualNumber);
    }
    
    public List<WebElement> locateElements(By elementBy){
        waitVisibility(elementBy);
        return driver.findElements(elementBy);
    }
}