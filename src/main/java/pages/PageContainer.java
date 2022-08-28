package pages;

import org.openqa.selenium.WebDriver;
import pages.cartPage.CartPage;
import pages.checkoutInfoPage.CheckoutInfoPage;
import pages.checkoutOverviewPage.CheckoutOverviewPage;
import pages.loginPage.LoginPage;
import pages.productsPage.ProductsPage;
import pages.thankYouPage.ThankYouPage;

public class PageContainer {
    public PageContainer(WebDriver driver) {
        loginPage = new LoginPage(driver);
        productPage = new ProductsPage(driver);
        cartPage = new CartPage(driver);
        checkoutInfoPage = new CheckoutInfoPage(driver);
        checkoutOverviewPage = new CheckoutOverviewPage(driver);
        thankYouPage = new ThankYouPage(driver);
    }

    public LoginPage loginPage;
    public ProductsPage productPage;
    public CartPage cartPage;
    public CheckoutInfoPage checkoutInfoPage;
    public CheckoutOverviewPage checkoutOverviewPage;
    public ThankYouPage thankYouPage;
}