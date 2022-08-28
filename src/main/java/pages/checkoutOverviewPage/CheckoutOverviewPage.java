package pages.checkoutOverviewPage;

import common.CommonPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class CheckoutOverviewPage extends CommonPage {
    public CheckoutOverviewPage(WebDriver driver) {
        super(driver);
    }

    private final By finishButton = By.xpath("//button[@data-test='finish']");
    private final By actualCorrectName = By.xpath("//*[@class='inventory_item_name']");


    public void checkCorrectProductNameInTheCart(String productName) {
        Assert.assertEquals(driver.findElement(actualCorrectName).getText(), productName, "Products are different");
    }

    public void finishOverviewing() {
        driver.findElement(finishButton).click();
    }
}