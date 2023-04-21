package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SaleTest extends BaseTest {
    String baseUrl;

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifyTheTotalItemsDisplayedOnTheWomensJacketsPage() {
        //Locating and clicking on 'Sale' menu tab
        driver.findElement(By.id("ui-id-8")).click();
        //Locating 'Jackets' and clicking on the link
        driver.findElement(By.linkText("Jackets")).click();
        //Expected text
        String expectedText = "Jackets";
        //Locating text element and getting text value
        String actualText = driver.findElement(By.xpath("//div[@class='page-title-wrapper']//h1/span[text()='Jackets']")).getText();
        //Validating expected and actual text
        Assert.assertEquals("Jackets text is not there.", expectedText, actualText);
        //Getting number of products displayed
        String expectedItems = driver.findElement(By.id("toolbar-amount")).getText();
        //Getting list of products displayed
        List<WebElement> jackets = driver.findElements(By.xpath("//div[@class='products wrapper grid products-grid']/ol/li[contains(@class,'item product')]//div[@class='product details product-item-details']//a[@class='product-item-link']"));
        // Getting actual number of products
        String actualItems = jackets.size() + " Items";
        //Iterating  list and printing titles of each element
        for (WebElement a : jackets) {
            System.out.println(a.getText());
            // Validating expected and actual text
            Assert.assertEquals("Total number of items displayed is not matching.", expectedItems, actualItems);
        }
    }

    @After
    public void tearDown() {
        closeBrowser();
    }

}
