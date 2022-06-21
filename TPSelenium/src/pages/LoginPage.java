package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    By usernameBy = By.id("user-name");
    By passwordBy = By.id("password");
    By loginButtonBy = By.id("login-button");

    String baseURL = "https://www.saucedemo.com/";
    By errorMessageBy = By.xpath("//*[@id='login_button_container']/div/form/div[3]/h3");

    public LoginPage basePage(){
        driver.get(baseURL);
        return this;
    }

    public LoginPage login (String username, String password){
        writeText(usernameBy, username);
        writeText(passwordBy, password);
        click(loginButtonBy);
        return this;
    }

    public LoginPage veryfyUnsucessfuLogin (String expectedText){
        String error = readText (errorMessageBy);
        assertStringEquals(error, expectedText);
        return this;
    }
    
}
