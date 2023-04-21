package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class LoginTest extends BaseTest {
    String baseUrl = "https://magento.softwaretestingboard.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {
        //Finding sign in link and clicking on it
        driver.findElement(By.xpath("//li[@class='authorization-link']")).click();
        //Finding email field and sending value
        driver.findElement(By.id("email")).sendKeys("johnsmith@gmail.com");
        //Finding password field and sending value
        driver.findElement(By.id("pass")).sendKeys("Password123!");
        //Finding and clicking on login button
        driver.findElement(By.id("send2")).click();
        //Expected text
        String expectedText = "Welcome";
        String actualText = driver.findElement(By.xpath("//div[@class='panel header']//li[@class='greet welcome']/span[contains(text(),'Welcome')]")).getText().substring(0, 7);
        //Validating expected and actual result
        Assert.assertEquals("User was not logged in successfully.", actualText, expectedText);
    }

    @Test
    public void verifyTheErrorMessageWithInvalidCredentials() {
        //Finding sign in link and clicking on it
        driver.findElement(By.xpath("//li[@class='authorization-link']")).click();
        //Finding email field and sending value
        driver.findElement(By.id("email")).sendKeys("johnsmith1@gmail.com");
        //Finding password field and sending value
        driver.findElement(By.id("pass")).sendKeys("Password123!");
        //Finding and clicking on login button
        driver.findElement(By.id("send2")).click();
        //Expected error
        String expectedError = "The account sign-in was incorrect or your account is disabled temporarily. Please wait and try again later.";
        //Finding and getting the text element
        String actualError = driver.findElement(By.xpath("//div[contains(text(),'The account sign-in was incorrect or your account ')]")).getText();
        // Validating expected and actual error messages
        Assert.assertEquals("Error message was not verified.", expectedError, actualError);
    }

    public void userShouldLogOutSuccessfully() {
        //Finding sign in link and clicking on it
        driver.findElement(By.xpath("//li[@class='authorization-link']")).click();
        //Finding email field and sending value
        driver.findElement(By.id("email")).sendKeys("johnsmith@gmail.com");
        //Finding password field and sending value
        driver.findElement(By.id("pass")).sendKeys("Password123!");
        //Finding and clicking on login button
        driver.findElement(By.id("send2")).click();
        //Expected text
        String expectedText = "Welcome";
        //Finding element and getting the text
        String actualText = driver.findElement(By.xpath("//div[@class='panel header']//li[@class='greet welcome']/span[contains(text(),'Welcome')]")).getText().substring(0, 7);
        //Validating expected and actual result
        Assert.assertEquals("User was not logged in successfully.", actualText, expectedText);
        //Expected message
        String expectedMessage1 = "You are signed out";
        //Finding and getting the text element and value
        String actualMessage1 = driver.findElement(By.xpath("//span[contains(text(),'You are signed out')]")).getText();
        //Validating expected and actual message
        Assert.assertEquals("User was unable to sign out.", expectedMessage1, actualMessage1);
    }

    @After
    public void tearDown(){
        closeBrowser();
    }
}
