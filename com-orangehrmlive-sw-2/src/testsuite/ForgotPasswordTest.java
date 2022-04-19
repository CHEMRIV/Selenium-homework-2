package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ForgotPasswordTest extends BaseTest {
    String baseUrl = "https://opensource-demo.orangehrmlive.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }
    @Test
    public void userShouldNavigateToForgotPasswordPageSuccessfully(){
        WebElement forgotPassword=driver.findElement(By.xpath("//a[contains(text(),'Forgot your password?')]"));
        forgotPassword.click();
        String expectedText="Forgot Your Password?";
        WebElement actualTextElement=driver.findElement(By.xpath("//h1[contains(text(),'Forgot Your Password?')]"));
        String actualText=actualTextElement.getText();
        System.out.println(actualText);
        //Validation
        Assert.assertEquals("Not match found",expectedText,actualText);
    }
    @After
    public void tearDown(){
        driver.close();
    }


}
