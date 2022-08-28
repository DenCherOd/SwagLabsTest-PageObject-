package common;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.PageContainer;

public class CommonTest {
    private WebDriver driver;
    public PageContainer pages;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        pages = new PageContainer(driver);
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void killBrowser() {
        driver.quit();
    }
}