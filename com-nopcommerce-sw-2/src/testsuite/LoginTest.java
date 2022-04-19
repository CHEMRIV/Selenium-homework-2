package testsuite;

import browserfactory.BaseTest;
import org.checkerframework.common.value.qual.StaticallyExecutable;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {
    String baseUrl = "https://demo.nopcommerce.com/";

    //opening browser
    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldNavigateToLoginPageSuccessfully() {
        WebElement loginLink = driver.findElement(By.linkText("Log in"));
        loginLink.click();
        //expected results
        String expectedMessage = "Welcome, Please Sign In!";
        //Find the welcome text element and get the text
        WebElement actualMessageElement = driver.findElement(By.xpath("//h1[contains(text(),'Welcome, Please Sign In!')]"));
        String actualMessage = actualMessageElement.getText();
        System.out.println(actualMessage);
        //Validation of actual and expected results
        Assert.assertEquals("Not navigate to login page", expectedMessage, actualMessage);
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {
        WebElement loginLink = driver.findElement(By.linkText("Log in"));
        loginLink.click();
        //Find email element
        WebElement emailId = driver.findElement(By.id("Email"));
        emailId.sendKeys("prime123@gmail.com");
        //Find password elements
        WebElement password = driver.findElement(By.name("Password"));
        password.sendKeys("prime123");
        WebElement logInSuccessful = driver.findElement(By.xpath("//button[contains(text(),'Log in')]"));
        logInSuccessful.click();
        //expected results
        String expectedText = "Log out";
        //Find the welcome text element and get the text
        WebElement actualTextElement = driver.findElement(By.xpath("//a[contains(text(),'Log out')]"));
        String actualText = actualTextElement.getText();
        System.out.println(actualText);
        //Validation of actual and expected results
        Assert.assertEquals("Not navigate to login page", expectedText, actualText);
    }

    @Test
    public void verifyTheErrorMessage() {
        WebElement loginLink = driver.findElement(By.linkText("Log in"));
        loginLink.click();
        //Find email element
        WebElement emailId = driver.findElement(By.id("Email"));
        emailId.sendKeys("beena1234@gmail.com");
        //Find password elements
        WebElement password = driver.findElement(By.name("Password"));
        password.sendKeys("beena1234");
        WebElement logInSuccessful = driver.findElement(By.xpath("//button[contains(text(),'Log in')]"));
        logInSuccessful.click();
        //expected results
        String expectedMessage = "Login was unsuccessful. Please correct the errors and try again.\n" +
                "No customer account found";
        //Find the welcome text element and get the text
        WebElement actualMessageElement = driver.findElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/form[1]/div[1]"));
        String actualMessage = actualMessageElement.getText();
        System.out.println(actualMessage);
        //Validation of actual and expected results
        Assert.assertEquals("Not navigate to login page", expectedMessage, actualMessage);
    }

    //Close browser
    @After
    public void tearDown() {
        closeBrowser();
    }
}
