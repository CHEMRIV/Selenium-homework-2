package testsuite;

import browserfactory.BaseTest;
import org.checkerframework.checker.units.qual.A;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {
    String baseUrl = "https://opensource-demo.orangehrmlive.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }
    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {
        //Enter email id
        WebElement login = driver.findElement(By.id("txtUsername"));
        login.sendKeys("Admin");
        //Enter password
        WebElement password = driver.findElement(By.name("txtPassword"));
        password.sendKeys("admin123");
        //log in
        WebElement login1 = driver.findElement(By.xpath("//input[@id='btnLogin']"));
        login1.click();
        //Check text 'Welcome'
        String expectedText = "Welcome";
        WebElement actualTextElement = driver.findElement(By.id("welcome"));
        String actualText = actualTextElement.getText();
        String actualTextFinal=actualText.substring(0,7);//get the exact actual message as required
        //validation of actual and expected results
        Assert.assertEquals("Not navigate to login page", expectedText, actualTextFinal);
    }

@After
    public void tearDown(){
        closeBrowser();
}

    }


