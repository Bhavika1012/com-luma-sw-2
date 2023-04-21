package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class RegisterTest extends BaseTest {
    String baseUrl = "https://magento.softwaretestingboard.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifyThatSignInPageDisplay() {
        //Finding and clicking 'Create an Account'
        driver.findElement(By.linkText("Create an Account")).click();
        //Expected text
        String expectedMessage = "Create New Customer Account";
        //finding the text element and getting the text value
        String actualMessage = driver.findElement(By.xpath("//span[contains(text(),'Create New Customer Account')]")).getText();
        Assert.assertEquals("Sign in page not displayed", expectedMessage, actualMessage);
    }

    @Test
    public void userShouldRegisterAccountSuccessfully() {
        //Finding and clicking 'Create an Account'
        driver.findElement(By.linkText("Create an Account")).click();
        //Finding and first name field and sending value
        driver.findElement(By.id("firstname")).sendKeys("John");
        //Finding and last name field and sending value
        driver.findElement(By.id("lastname")).sendKeys("Smith");
        //Finding sign up for newsletter check box and selecting it
        driver.findElement(By.id("is_subscribed")).click();
        //Finding and email field and sending value
        driver.findElement(By.id("email_address")).sendKeys("johnsmith@gmail.com");
        //Finding password field and sending value
        driver.findElement(By.id("password")).sendKeys("Password123!");
        //Finding and password confirmation field and sending value
        driver.findElement(By.id("password-confirmation")).sendKeys("Password123!");
        driver.findElement(By.cssSelector(".action.submit.primary")).click();
        //Expected message
        String expectedMessage = "Thank you for registering with Main Website Store.";
        //Finding text element and getting text value
        String actualMessage = driver.findElement(By.xpath("//div[contains(text(),'Thank you for registering with Main Website Store.')]")).getText();
        //Validating the expected and actual message
        Assert.assertEquals("User was unable to register successfully", expectedMessage, actualMessage);
//Finding drop down arrow icon next to welcome username and clicking on it
        driver.findElement(By.xpath("//button[@class='action switch']")).click();
        //Finding and clicking on Sign out
        driver.findElement(By.xpath("//li[@class='authorization-link']")).click();
        //Expected message from requirements
        String expectedMessage1 = "You are signed out";
        //Finding text element and getting the text value
        String actualMessage1 = driver.findElement(By.xpath("//span[contains(text(),'You are signed out')]")).getText();
        //Validating the expected and actual message
        Assert.assertEquals("User was unable to sign out.", expectedMessage1, actualMessage1);
    }

    @After
    public void tearDown() {
        closeBrowser();
    }
}