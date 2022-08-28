package pages.thankYouPage;

import common.CommonPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class ThankYouPage extends CommonPage {
    public ThankYouPage(WebDriver driver) {
        super(driver);
    }

    private final By thanksMessage = new By.ByXPath("//*[text()='THANK YOU FOR YOUR ORDER']");

    public void checkSeccesfullyOfTheOrder(String message) {
        Assert.assertEquals(driver.findElement(thanksMessage).getText(), message, "Message is not correct");
    }
}