package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    By loginLink = By.id("login2");
    By cartLink = By.id("cartur");
    By phoneLink = By.xpath("//a[text()='Samsung galaxy s6']");

    public void clickLogin() {
        driver.findElement(loginLink).click();
    }

    public void clickCart() {
        driver.findElement(cartLink).click();
    }

    public void selectProduct() {
        driver.findElement(phoneLink).click();
    }
}