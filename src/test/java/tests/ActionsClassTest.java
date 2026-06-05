import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ActionsClassTest {

    WebDriver driver;

    @BeforeClass
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/hovers");
    }

    @Test
    public void testMouseHover() {
        WebElement firstUserImage = driver.findElement(By.xpath("(//div[@class='figure'])[1]"));
        Actions actions = new Actions(driver);

        actions.moveToElement(firstUserImage).perform();

        WebElement profileLink = driver.findElement(By.xpath("(//a[text()='View profile'])[1]"));
        Assert.assertTrue(profileLink.isDisplayed());
        System.out.println("Step: Mouse hover via Actions class working fine.");
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}