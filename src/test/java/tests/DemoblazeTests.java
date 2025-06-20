package tests;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.*;

public class DemoblazeTests {

    WebDriver driver;
    HomePage home;
    LoginPage login;
    CartPage cart;
    PlaceOrderPage order;

    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.demoblaze.com/");
        home = new HomePage(driver);
        login = new LoginPage(driver);
        cart = new CartPage(driver);
        order = new PlaceOrderPage(driver);
    }

    @Test(priority = 1)
    public void loginTest() throws InterruptedException {
        home.clickLogin();
        login.login("testuser", "testpass");
        Thread.sleep(2000);
        Assert.assertTrue(driver.getPageSource().contains("Welcome"), "Login failed!");
    }

    @Test(priority = 2)
    public void addToCartAndPlaceOrder() throws InterruptedException {
        home.selectProduct();
        Thread.sleep(2000);
        driver.findElement(By.linkText("Add to cart")).click();
        Thread.sleep(2000);
        driver.switchTo().alert().accept();
        home.clickCart();
        cart.placeOrder();
        order.fillDetailsAndPurchase("Noel", "1234567890123456");
        Assert.assertTrue(order.getConfirmation().contains("Thank you"), "Order failed!");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}