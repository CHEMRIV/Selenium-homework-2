package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class LoginTest extends BaseTest {
    String baseUrl = "https://www.saucedemo.com/";

    @Before
    public void setUp() {
        //open baseUrl
        openBrowser(baseUrl);
    }

    @Test
    public void userSholdLoginSuccessfullyWithValidCredentials() {
        //Enter email id
        WebElement login = driver.findElement(By.id("user-name"));
        login.sendKeys("standard_user");
        //Enter password
        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("secret_sauce");
        //log in
        WebElement login1 = driver.findElement(By.id("login-button"));
        login1.click();
        //Check icon 'PRODUCTS'
        String expectedText = "PRODUCTS";
        WebElement actualMessageElement = driver.findElement(By.xpath("//span[contains(text(),'Products')]"));
        String actualText = actualMessageElement.getText();
        //validation of actual and expected results
        Assert.assertEquals("Not navigate to login page", expectedText, actualText);

    }

    @Test
    public void verifyThatSixProductsAreDisplayedOnPage() {
        //Enter email id
        WebElement login = driver.findElement(By.id("user-name"));
        login.sendKeys("standard_user");
        //Enter password
        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("secret_sauce");
        //log in
        WebElement login1 = driver.findElement(By.id("login-button"));
        login1.click();
        //count 'PRODUCTS' on webpage by using item label
        List<WebElement> productsList = driver.findElements(By.className("inventory_item_label"));
        int sizeOfList = productsList.size();
        System.out.println("Count of products displayed on page is : "+sizeOfList);

    }

    @After
    public void tearDown() {
        closeBrowser();
 }
}
