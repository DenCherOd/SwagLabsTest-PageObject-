package pages.cartPage;

import common.CommonPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class CartPage extends CommonPage {
    public CartPage(WebDriver driver) {
        super(driver);
    }

    private final By checkoutButton = By.xpath("//button[@id='checkout']");
    private String removeItemFromCartButton = "//*[text()='#productName#']//ancestor::*//*[text()='Remove']";

    public void makeCheckout() {
        waitForVisible(checkoutButton);
        driver.findElement(checkoutButton).click();
    }

    public void deleteItemFromTheCart(String productName) {
        removeItemFromCartButton = removeItemFromCartButton.replace("#productName#", productName);
        driver.findElement((By.xpath(removeItemFromCartButton))).click();
    }

    public void checkProductIsDeleted(String productName) {
        Assert.assertTrue(driver.findElement(By.xpath(productName)).isDisplayed(), "Product was not deleted");
    }
}