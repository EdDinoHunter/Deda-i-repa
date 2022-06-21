package tests;

import org.junit.Test;

import pages.HomePage;
import pages.LoginPage;

public class LoginTests extends BaseTest{

    public LoginPage loginPage;
    public HomePage homePage;
    String homePageTitle = "PRODUCTS";
    String lockedOutUser = "locked_out_user";
    String invalidUsername = "wrong_username";
    String invalidPassword = "wrong_password";
    String errorMessageLockedOutUser = "Epic sadface: Sorry, this user has been locked out.";
    String errorMessageInvalidUsername = "Epic sadface: Username and password do not match any user in this service";
    String errorMessageInvalidPassword = "Epic sadface: Username and password do not match any user in this service";
    String errorMessageMissingUsername = "Epic sadface: Username is required";
    String errorMessageMissingPassword = "Epic sadface: Password is required";

    @Test
    public void validLoginTest(){
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);

        loginPage.basePage();
        loginPage.login(validUsername, validPassword);
        homePage.verifyLogin(homePageTitle);
        }

    @Test
    public void lockedOutUserTest(){
        loginPage = new LoginPage(driver);

        loginPage.basePage();
        loginPage.login(lockedOutUser, validPassword);
        loginPage.veryfyUnsucessfuLogin(errorMessageLockedOutUser);
    }

    @Test
    public void invalidUsernameTest(){
        loginPage = new LoginPage(driver);

        loginPage.basePage();
        loginPage.login(invalidUsername, validPassword);
        loginPage.veryfyUnsucessfuLogin(errorMessageInvalidUsername);
    }

    @Test
    public void invalidPasswordTest(){
        loginPage = new LoginPage(driver);

        loginPage.basePage();
        loginPage.login(validUsername, invalidPassword);
        loginPage.veryfyUnsucessfuLogin(errorMessageInvalidPassword);
    }

    @Test
    public void emptyUsernameTest(){
        loginPage = new LoginPage(driver);

        loginPage.basePage();
        loginPage.login("", validPassword);
        loginPage.veryfyUnsucessfuLogin(errorMessageMissingUsername);
    }

    @Test
    public void emptyPasswordTest(){
        loginPage = new LoginPage(driver);

        loginPage.basePage();
        loginPage.login(validUsername, "");
        loginPage.veryfyUnsucessfuLogin(errorMessageMissingPassword);
    }
}