package browserfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class BaseTest {
    public static WebDriver driver; //Variable driver of Web element type

    public void openBrowser(String baseUrl) {
        driver = new ChromeDriver(); //assign variable to object of Chrome Driver class
        //Launching browser
        driver.get("https://magento.softwaretestingboard.com/");
        //maximising browser
        driver.manage().window().maximize();
        //adding implicit wait time
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    public void closeBrowser() {
        driver.quit(); //Closing all selenium browsers
    }
}
