package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PlaceOrderPage extends BasePage {
    public PlaceOrderPage(WebDriver driver) {
        super(driver);
    }

    By name = By.id("name");
    By card = By.id("card");
    By purchaseBtn = By.xpath("//button[text()='Purchase']");
    By confirmation = By.className("sweet-alert");

    public void fillDetailsAndPurchase(String userName, String cardNo) {
        driver.findElement(name).sendKeys(userName);
        driver.findElement(card).sendKeys(cardNo);
        driver.findElement(purchaseBtn).click();
    }

    public String getConfirmation() {
        return driver.findElement(confirmation).getText();
    }
}