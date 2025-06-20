package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage {
    public CartPage(WebDriver driver) {
        super(driver);
    }

    By placeOrderBtn = By.xpath("//button[text()='Place Order']");

    public void placeOrder() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(placeOrderBtn).click();
    }
}