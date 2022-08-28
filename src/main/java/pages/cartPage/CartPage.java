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
    private String productNameInTheCart = "//div[text()='#productName#']";


    public void makeCheckout() {
        waitForVisible(checkoutButton);
        driver.findElement(checkoutButton).click();
    }

    public void deleteItemFromTheCart(String productName) {
        removeItemFromCartButton = removeItemFromCartButton.replace("#productName#", productName);
        waitForVisible(By.xpath(removeItemFromCartButton));
        driver.findElement((By.xpath(removeItemFromCartButton))).click();
    }

    public void checkProductIsDeleted(String productName) {
        productNameInTheCart = productNameInTheCart.replace("#productName#", productName);
        Assert.assertFalse(waitForLocated(By.xpath(productNameInTheCart)), "Element is present");
    }
}