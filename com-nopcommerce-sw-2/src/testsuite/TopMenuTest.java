package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TopMenuTest extends BaseTest {
    String baseUrl = "https://demo.nopcommerce.com/";

    //opening browser
    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldNavigateToComputerPageSuccessfully() {
        //click on computer tab on tab manu
        WebElement computer = driver.findElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[1]/a[1]"));
        computer.click();
        //Verify the text ‘Computers’
        String expectedText = "Computers";
        WebElement actualTextElement = driver.findElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[1]/a[1]"));
        String actualText = actualTextElement.getText();
        System.out.println(actualText);
        //Validation of actual and expected results
        Assert.assertEquals("Not Match with expected results", actualText, expectedText);
    }

    @Test
    public void userShouldNavigateToElectronicsPageSuccessfully() {
        //click on electronics tab on tab manu
        WebElement electronics = driver.findElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[2]/a[1]"));
        electronics.click();
        //Verify the text ‘Electronics’
        String expectedText = "Electronics";
        WebElement actualTextElement = driver.findElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[2]/a[1]"));
        String actualText = actualTextElement.getText();
        System.out.println(actualText);
        //validation of actual and expected results
        Assert.assertEquals("Not Match with expected results", actualText, expectedText);
    }

    @Test
    public void serShouldNavigateToApparelPageSuccessfully() {
        //click on Apparel tab on tab manu
        WebElement apparel = driver.findElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[3]/a[1]"));
        apparel.click();
        //Verify the text ‘Apparel’
        String expectedText = "Apparel";
        WebElement actualTextElement = driver.findElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[3]/a[1]"));
        String actualText = actualTextElement.getText();
        System.out.println(actualText);
        //validation of actual and expected results
        Assert.assertEquals("Not Match with expected results", actualText, expectedText);
    }

    @Test
    public void userShouldNavigateToDigitalDownloadsPageSuccessfully() {
        //click on Digital downloads tab on tab manu
        WebElement digitalDownloads = driver.findElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[4]/a[1]"));
        digitalDownloads.click();
        //Verify the text ‘Digital downloads’
        String expectedText = "Digital downloads";
        WebElement actualTextElement = driver.findElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[4]/a[1]"));
        String actualText = actualTextElement.getText();
        System.out.println(actualText);
        //validation of actual and expected results
        Assert.assertEquals("Not Match with expected results", actualText, expectedText);
    }

    @Test
    public void userShouldNavigateToBooksPageSuccessfully() {
        //click on Books tab on tab manu
        WebElement books = driver.findElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[5]/a[1]"));
        books.click();
        //Verify the text ‘Books’
        String expectedText = "Books";
        WebElement actualTextElement = driver.findElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[5]/a[1]"));
        String actualText = actualTextElement.getText();
        System.out.println(actualText);
        //validation of actual and expected results
        Assert.assertEquals("Not Match with expected results", actualText, expectedText);
    }

    @Test
    public void userShouldNavigateToJewelryPageSuccessfully() {
        //click on Jewelry tab on tab manu
        WebElement Jewelry = driver.findElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[6]/a[1]"));
        Jewelry.click();
        //Verify the text ‘Jewelry’
        String expectedText = "Jewelry";
        WebElement actualTextElement = driver.findElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[6]/a[1]"));
        String actualText = actualTextElement.getText();
        System.out.println(actualText);
        //validation of actual and expected results
        Assert.assertEquals("Not Match with expected results", actualText, expectedText);
    }
    @Test
    public void userShouldNavigateToGiftCardsPageSuccessfully() {
        //click on Gift Cards tab on tab manu
        WebElement giftCards = driver.findElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[7]/a[1]"));
        giftCards.click();
        //Verify the text ‘Gift Cards’
        String expectedText = "Gift Cards";
        WebElement actualTextElement = driver.findElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[7]/a[1]"));
        String actualText = actualTextElement.getText();
        System.out.println(actualText);
        //validation of actual and expected results
        Assert.assertEquals("Not Match with expected results", actualText, expectedText);
    }

    //Close browser
    @After
    public void tearDown() {
        closeBrowser();
    }
}