package tests;

import org.junit.Test;

import pages.HomePage;
import pages.LoginPage;

public class HomePageTest extends BaseTest{

    public LoginPage loginPage;
    public HomePage homePage;

    int numberOfAllItems = 6;


    @Test
    public void checkNumberOfItemsOnHomePage(){

        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);

        loginPage.basePage();
        loginPage.login(validUsername, validPassword);
        homePage.validateNumberOfProducts(numberOfAllItems);
    }
}
