package pages.checkoutInfoPage;

import common.CommonPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutInfoPage extends CommonPage {
    public CheckoutInfoPage(WebDriver driver) {
        super(driver);
    }

    private final By firstNameInput = By.xpath("//input[@data-test='firstName']");
    private final By lastNameInput = By.xpath("//input[@data-test='lastName']");
    private final By postalCodeInput = By.xpath("//input[@data-test='postalCode']");
    private final By continueButton = By.xpath("//input[@data-test='continue']");

    public void fillCheckoutInformation(String firstName, String lastName, String postalCode) {
        driver.findElement(firstNameInput).sendKeys(firstName);
        driver.findElement(lastNameInput).sendKeys(lastName);
        driver.findElement(postalCodeInput).sendKeys(postalCode);
        driver.findElement(continueButton).click();
    }
}