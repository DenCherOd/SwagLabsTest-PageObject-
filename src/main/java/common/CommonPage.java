package common;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CommonPage {
    protected WebDriver driver;

    public CommonPage(WebDriver driver) {
        this.driver = driver;
    }

    protected boolean waitForVisible(By locator) {
        System.out.println("Wait for visible " + locator);
        boolean isVisible = true;
        try {
            new WebDriverWait(driver, Duration.ofSeconds(10))
                    .until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
        } catch (TimeoutException e) {
            System.out.println("Can not find " + locator);
            isVisible = false;
        }
        return isVisible;
    }

    protected boolean waitForLocated(By locator) {
        System.out.println("Wait for located: " + locator);
        boolean isLocated = true;
        try {
            new WebDriverWait(driver, Duration.ofSeconds(10))
                    .until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
        } catch (TimeoutException e) {
            System.out.println("Can not find " + locator);
            isLocated = false;
        }
        return isLocated;
    }
}