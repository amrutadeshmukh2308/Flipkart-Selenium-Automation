import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.time.Duration;

import static java.awt.SystemColor.window;

public class FlipkartTest {
    WebDriver driver;
    WebDriverWait wait;
    @BeforeMethod
    public void setup(){
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.flipkart.com");
        wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        System.out.println("Step: Browser launched and flipkart opened.");
    }
    @Test(priority = 1)
    public void testCloseLoginPopup(){
        try{
            WebElement closeButton=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='-30XB9F")));
            closeButton.click();
            System.out.println("Login popup closed successfully. ");
        }catch (Exception e){
            System.out.println("Login popup not displayed, directly on homepage.");
        }
    }
    @Test(priority =2)
    public void testSearchValidProduct(){
        try {
            WebElement searchBox=wait.until(ExpectedConditions.elementToBeClickable(By.name("q")));
       searchBox.sendKeys(Keys.ENTER);
        }
        catch (Exception e){
            System.out.println("Product search faild:"+e.getMessage());
        }
    }
    @Test(priority = 3)
    public void testVerifySearchResults(){
        try{
            WebElement resultText=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[contains(text(),'results for')]")));
            if(resultText.isDisplayed()){
                System.out.println("Search results valildated on UI. test is:"+resultText.getText());
            }
            }
        catch(Exception e){
            System.out.println("Faild to verify search result text. ");

        }
    }
    @Test
    public void testSortByPriceLowToHigh(){
        try {
            WebElement lowToHighTab = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[text()='Price -- low to Hight']")));
            lowToHighTab.click();
            Thread.sleep(3000);
            System.out.println("Sorted Products by price Low to High. ");
        }
        catch (Exception e){
            System.out.println("failed to apply low to high sorting");
        }
    }
    @Test(priority = 5)
    public void testFilterByBrandApple() {
        try {
            WebElement appleCheckbox = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='_24_XB_']//div[text()='Apple']")));
            appleCheckbox.click();
            Thread.sleep(3000);
            System.out.println("Brand filter 'Apple' Applied successfully");
        }
        catch (Exception e){
            System.out.println("Failed to apply apple brand filter. ");
        }
    }
    @Test(priority = 6)
    public void testClickFirstProduct() {
        try {
            WebElement firstProduct = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[contains(@class,'KzDlHZ')])[1]")));
            firstProduct.click();
            System.out.println(" Clicked on the first product successfully.");
            Thread.sleep(3000);
        } catch (Exception e) {
            System.out.println(" Failed to click on the first product: " + e.getMessage());
        }
    }

    @Test(priority = 7)
    public void testSwitchToProductTab() {
        try {
            String parentWindow = driver.getWindowHandle();
            for (String currentWindow : driver.getWindowHandles()) {
                if (!currentWindow.equals(parentWindow)) {
                    driver.switchTo().window(currentWindow);
                }
            }
            System.out.println("Switched to the new product tab successfully.");
        } catch (Exception e) {
            System.out.println("Failed to switch to the new tab.");
        }
    }

    @Test(priority = 8)
    public void testVerifyProductTitleAndPrice() {
        try {
            WebElement productTitle = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@class='VU-ZEg']")));
            WebElement productPrice = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='Nx9w9m _10O9QC']")));
            if (productTitle.isDisplayed() && productPrice.isDisplayed()) {
                System.out.println(" Product Title verified: " + productTitle.getText());
                System.out.println("Product Price verified: " + productPrice.getText());
            }
        } catch (Exception e) {
            System.out.println(" Failed to verify product title or price.");
        }
    }

    @Test(priority = 9)
    public void testAddProductToCart() {
        try {
            WebElement addToCartBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Add to cart']")));
            addToCartBtn.click();
            System.out.println(" Clicked on Add to Cart button.");
            Thread.sleep(4000);
        } catch (Exception e) {
            System.out.println(" Failed to click Add to Cart button.");
        }
    }

    @Test(priority = 10)
    public void testGoToCartPage() {
        try {
            WebElement priceDetailsHeader = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[text()='Price details']")));
            if (priceDetailsHeader.isDisplayed()) {
                System.out.println(" Navigated to Cart page successfully.");
            }
        } catch (Exception e) {
            System.out.println("Failed to verify Cart page.");
        }
    }
    @Test(priority = 11)
    public void testIncreaseQuantityInCart() {
        try {
            WebElement plusButton = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//button[text()='+']")));
            plusButton.click();
            System.out.println("Increased product quantity in cart by 1.");
            Thread.sleep(3000);
        } catch (Exception e) {
            System.out.println(" Failed to increase quantity.");
        }
    }

    @Test(priority = 12)
    public void testVerifyTotalPriceUpdated() {
        try {
            WebElement totalAmount = wait.until(ExpectedConditions.presenceOfElementLocated(
                    By.xpath("//div[@class='_1Y9vON']//span")));
            if (totalAmount.isDisplayed()) {
                System.out.println(" Total price updated in cart. Current Total: " + totalAmount.getText());
            }
        } catch (Exception e) {
            System.out.println(" Failed to verify updated total price.");
        }
    }

    @Test(priority = 13)
    public void testRemoveProductFromCart() {
        try {
            WebElement removeBtn = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//div[text()='Remove']")));
            removeBtn.click();

            WebElement confirmRemove = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//div[@class='sB2FrG _10g9w-']//div[text()='Remove']")));
            confirmRemove.click();

            System.out.println(" Product removed from cart successfully.");
            Thread.sleep(3000);
        } catch (Exception e) {
            System.out.println("Failed to remove product from cart.");
        }
    }

    @Test(priority = 14)
    public void testSearchInvalidProduct() {
        try {
            driver.get("https://www.flipkart.com");
            WebElement searchBox = wait.until(ExpectedConditions.elementToBeClickable(By.name("q")));
            searchBox.sendKeys("xyzabc123456");
            searchBox.sendKeys(Keys.ENTER);

            WebElement noResultsMsg = wait.until(ExpectedConditions.presenceOfElementLocated(
                    By.xpath("//div[contains(text(),'Sorry, no results found')]")));

            if (noResultsMsg.isDisplayed()) {
                System.out.println(" Negative test passed. 'No results found' message verified.");
            }
        } catch (Exception e) {
            System.out.println("Failed to verify invalid search behavior.");
        }
    }

    @Test(priority = 15)
    public void testClearSearchAndNavigateHome() {
        try {
            WebElement searchBox = wait.until(ExpectedConditions.elementToBeClickable(By.name("q")));
            searchBox.clear();
            System.out.println(" Cleared the search bar inputs.");

            WebElement logo = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//img[@title='Flipkart']")));
            logo.click();
            System.out.println(" Clicked on Flipkart logo to return to homepage.");
        } catch (Exception e) {
            System.out.println("Failed to clear search or navigate home.");
        }
    }
    @Test(priority = 16)
    public void testValidateLoginErrorMessage() {
        try {
            driver.get("https://www.flipkart.com");

            WebElement loginLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(@href, 'login')]")));
            loginLink.click();

            WebElement phoneInput = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@class='r4v17b']")));
            phoneInput.sendKeys("9945678214");
            phoneInput.sendKeys(Keys.ENTER);

            WebElement errorMsg = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='This text does not exist']")));

            if(errorMsg.isDisplayed()) {
                System.out.println("Error message validated.");
            }
        } catch (Exception e) {
            System.out.println(" Execution failed due to element unavailability: " + e.getMessage());
            throw e;
        }
    }
    @AfterMethod
    public void captureScreenshotOnFailure(ITestResult result) {
        if (ITestResult.FAILURE == result.getStatus()) {
            try {
                TakesScreenshot ts = (TakesScreenshot) driver;
                File source = ts.getScreenshotAs(OutputType.FILE);
                File destination = new File("./Screenshots/" + result.getName() + ".png");
                org.apache.commons.io.FileUtils.copyFile(source, destination);
                System.out.println("Screenshot captured for failed test: " + result.getName());
            } catch (Exception e) {
                System.out.println("Exception while taking screenshot: " + e.getMessage());
            }
        }
    }
}
