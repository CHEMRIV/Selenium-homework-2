package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {
    String baseUrl = "http://the-internet.herokuapp.com/login";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {
        //Enter email id
        WebElement login = driver.findElement(By.id("username"));
        login.sendKeys("tomsmith");
        //Enter password
        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("SuperSecretPassword!");
        //log in
        WebElement login1 = driver.findElement(By.xpath("//i[@class='fa fa-2x fa-sign-in']"));
        login1.click();
    }

    @Test
    public void verifyTheUsernameErrorMessage() {
        //Enter invalid email id
        WebElement login = driver.findElement(By.id("username"));
        login.sendKeys("tomsmith1");
        //Enter password
        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("SuperSecretPassword!");
        //log in
        WebElement login1 = driver.findElement(By.xpath("//i[@class='fa fa-2x fa-sign-in']"));
        login1.click();

        //Check text 'Your username is invalid!'
        String expectedText = "Your username is invalid!";
        WebElement actualMessageElement = driver.findElement(By.xpath("//div[@id='flash']"));
        String actualText = actualMessageElement.getText();
        String actualTextFinal = actualText.substring(0, 25);//get the exact actual message as required
        //validation of actual and expected results
        Assert.assertEquals("Not navigate to login page", expectedText, actualTextFinal);

    }

    @Test
    public void verifyThePasswordErrorMessage() {
        //Enter valid email id
        WebElement login = driver.findElement(By.id("username"));
        login.sendKeys("tomsmith");
        //Enter invalid password
        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("SuperSecretPassword");
        //log in
        WebElement login1 = driver.findElement(By.xpath("//i[@class='fa fa-2x fa-sign-in']"));
        login1.click();
        //Check text 'Your username is invalid!'
        String expectedText = "Your password is invalid!";
        WebElement actualMessageElement = driver.findElement(By.xpath("//div[@id='flash']"));
        String actualText = actualMessageElement.getText();
        String actualTextFinal = actualText.substring(0, 25);//get the exact actual message as required
        //validation of actual and expected results
        Assert.assertEquals("Not navigate to login page", expectedText, actualTextFinal);

    }

    @After
    public void tearDown() {
        closeBrowser();
    }

}


