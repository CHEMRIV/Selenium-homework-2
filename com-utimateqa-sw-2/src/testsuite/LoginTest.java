package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {
    String baseUrl = "https://courses.ultimateqa.com/";

    @Before
    public void setUp() {
        //open baseUrl
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldNavigateToLoginPageSuccessfully() {
        WebElement signIn = driver.findElement(By.xpath("//a[contains(text(),'Sign In')]"));
        signIn.click();
        String expectedMessage = "Welcome Back!";
        //findout the actual elements
        WebElement actualMessageElement = driver.findElement(By.xpath("//h1[@class='page__heading']"));
        String actualMessage = actualMessageElement.getText();////h1[@class='page__heading']
        //validation of actual and expected message
        Assert.assertEquals("Not navigate to Sign In page", expectedMessage, actualMessage);
    }

    @Test
    public void verifyTheErrorMessage() {
        //click on signin link
        WebElement signIn = driver.findElement(By.xpath("//a[contains(text(),'Sign In')]"));
        signIn.click();
        // Enter invalid username
        WebElement email = driver.findElement(By.id("user[email]"));
        email.sendKeys("abc123@gmail.com");
        // Enter invalid password
        WebElement password = driver.findElement(By.name("user[password]"));
        password.sendKeys("123456");
        //Click on Login button
        WebElement logIn = driver.findElement(By.xpath("//input[@class='button button-primary g-recaptcha']"));
        logIn.click();
        //find out error massage display or not
        String expectedError = "Invalid email or password.";
        WebElement actualErrorElement = driver.findElement(By.xpath("//li[contains(text(),'Invalid email or password.')]"));
        String actualError = actualErrorElement.getText();
      //validation of actual and expected errors
        Assert.assertEquals("Not match found",expectedError,actualError);
    }

    @After
    public void tearDown() {
        //closeBrowser()
    }
}
