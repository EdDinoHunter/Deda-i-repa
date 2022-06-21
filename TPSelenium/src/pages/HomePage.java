package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver){
        super(driver);
    }

    By headerTitleBy = By.xpath("//*[@id='header_container']/div[2]/span");
    By numberOfItemsBy = By.xpath("//*[@class='inventory_item']");
    By menuTitleBy = By.xpath("//*[@id='react-burger-menu-btn']");
    By aboutButton = By.xpath("//*[@id='about_sidebar_link']");
    String expectedHref = "https://saucelabs.com/";


    public HomePage verifyLogin (String expectedText){
    String pageTitle = readText(headerTitleBy);
    assertStringEquals(pageTitle, expectedText);
    return this;
    }


    public HomePage validateNumberOfProducts(int expectedNumberOfProducts){
        int actualNumberOfProducts = locateElements(numberOfItemsBy).size();
        assertIntegerEquals(expectedNumberOfProducts, actualNumberOfProducts);
        return this;
    }

    public HomePage openMenu(String expectedText){
        String menuTitle = readText(menuTitleBy);
        assertStringEquals(menuTitle, expectedText);
        return this;
    }

    public HomePage verifyAboutLink(){
        String actualHref = readHref(aboutButton);
        assertStringEquals(expectedHref, actualHref);
        return this;
    }
}