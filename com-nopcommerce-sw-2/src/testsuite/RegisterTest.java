package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class RegisterTest extends BaseTest {

    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldNavigateToRegisterPageSuccessfully() {
        //click on Register button
        WebElement register = driver.findElement(By.linkText("Register"));
        register.click();
        //Verify the text ‘Register’
        String expectedText = "Register";
        WebElement actualTextElement = driver.findElement(By.linkText("Register"));
        String actualText = actualTextElement.getText();
        System.out.println(actualText);
        //Validation of actual and expected results
        Assert.assertEquals("Not Match with expected results", actualText, expectedText);
    }

    @Test
    public void userShouldRegisterAccountSuccessfully() {
        //click on Register button
        WebElement register = driver.findElement(By.linkText("Register"));
        register.click();
        //click on gender male button
        WebElement genderButton = driver.findElement(By.id("gender-male"));
        genderButton.click();
        //click on gender female button
        WebElement genderButton1 = driver.findElement(By.id("gender-female"));
        genderButton1.click();
        //fill first name
        WebElement firstName = driver.findElement(By.xpath("//input[@id='FirstName']"));
        firstName.sendKeys("Pooja");
        //fill last name
        WebElement lastName = driver.findElement(By.xpath("//input[@name='LastName']"));
        lastName.sendKeys("Patel");
        //select date of birth-Day
        WebElement day = driver.findElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/form[1]/div[1]/div[2]/div[4]/div[1]/select[1]"));
        day.sendKeys("28");
        //select date of birth-Month
        WebElement month = driver.findElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/form[1]/div[1]/div[2]/div[4]/div[1]/select[2]"));
        month.sendKeys("April");
        //select date of birth-Year
        WebElement year = driver.findElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/form[1]/div[1]/div[2]/div[4]/div[1]/select[3]"));
        year.sendKeys("1991");
        WebElement emailId = driver.findElement(By.xpath("//input[@id='Email']"));
        emailId.sendKeys("pooja321@gmail.com");
        WebElement password=driver.findElement(By.xpath("//input[@id='Password']"));
        password.sendKeys("123456");
        WebElement conformPassword=driver.findElement(By.xpath("//input[@id='ConfirmPassword']"));
        conformPassword.sendKeys("123456");
        WebElement register1 =driver.findElement(By.xpath("//button[@id='register-button']"));
        register1.click();
        String expectedText = "Your registration completed";
        WebElement actualTextElement = driver.findElement(By.xpath("//div[contains(text(),'Your registration completed')]"));
        String actualText = actualTextElement.getText();
        System.out.println(actualText);
        //Validation of actual and expected results
        Assert.assertEquals("Not Match with expected results", actualText, expectedText);

    }
    @After
    public void teardown(){
      //  closeBrowser();
    }
}