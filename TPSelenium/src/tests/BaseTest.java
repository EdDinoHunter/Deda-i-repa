package tests;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class BaseTest {
    public WebDriver driver;
    public FirefoxOptions options;

    String validUsername = "standard_user";
    String validPassword = "secret_sauce";

    @Before
    public void setup(){
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\QA23\\Desktop\\Selenium\\TPSelenium\\lib\\geckodriver.exe");
        //FirefoxOptions options = new FirefoxOptions();
        //options.setHeadless(true); //<--headless set here
        driver = new FirefoxDriver();

        //driver.manage().window().maximize();
    }

    @After
    public void teardown(){
        driver.quit();
    }
    
}
